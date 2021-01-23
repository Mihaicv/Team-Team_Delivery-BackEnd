package com.glovo.ttglovo.registration.token;

import com.glovo.ttglovo.appuser.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "confirmation_token")
public class ConfirmationToken {

    @Id
    @SequenceGenerator(
            name="confirmation_token_sequence",
            sequenceName = "confirmation_token_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "confirmation_token_sequence"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name="token", nullable = false)
    private String token;

    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name="expiresAt", nullable = false)
    private LocalDateTime expiresAt;
    private LocalDateTime confirmedAt;

    @ManyToOne
     @JoinColumn(nullable = false,
     name="app_user_id")
    private AppUser appUser;

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt, AppUser appUser) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.appUser=appUser;
    }
}
