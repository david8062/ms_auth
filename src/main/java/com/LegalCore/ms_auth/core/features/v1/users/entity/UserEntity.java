package com.LegalCore.ms_auth.core.features.v1.users.entity;

import com.LegalCore.ms_auth.core.base.BaseEntity;
import com.LegalCore.ms_auth.shared.enums.UserStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "users")
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"tenant_id", "username"})
        }
)
public class UserEntity extends BaseEntity {

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "second_name", length = 100)
    private String secondName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "second_last_name", length = 100)
    private String secondLastName;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "address", length = 200)
    private String address;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "email", length = 150, unique = true, nullable = false)
    private String email;

    @Column(name = "username", length = 100)
    private String username;

    @Column(name = "document_type", length = 50)
    private String documentType;

    @Column(name = "document_number", length = 100)
    private String documentNumber;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "two_fa")
    private Boolean twoFa = false;

    @Column(name = "user_type", length = 100)
    private String userType;  // external_id → billing

    @Column(name = "tenant_id", length = 100)
    private String tenantId;  // external_id → tenant_manager
    @Column(name = "status", length = 50)

    @Enumerated(EnumType.STRING)
    private UserStatusEnum status = UserStatusEnum.valueOf("ACTIVE");
}
