CREATE EXTENSION IF NOT EXISTS pgcrypto;
-- ============================
--  USERS
-- ============================
CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    first_name          VARCHAR(100),
    second_name         VARCHAR(100),
    last_name           VARCHAR(100),
    second_last_name    VARCHAR(100),

    country             VARCHAR(100),
    city                VARCHAR(100),
    address             VARCHAR(200),

    phone               VARCHAR(50),
    email               VARCHAR(150) UNIQUE NOT NULL,

    document_type       VARCHAR(50),
    document_number     VARCHAR(100),

    password            VARCHAR(255) NOT NULL,

    two_fa              BOOLEAN DEFAULT FALSE,

    user_type           VARCHAR(100),     -- external_id → billing
    tenant_id           VARCHAR(100),     -- external_id → tenant_manager

    created_at          TIMESTAMP DEFAULT NOW(),
    updated_at          TIMESTAMP DEFAULT NOW()
);

CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_tenant_id ON users(tenant_id);


-- ============================
--  PASSWORDS_CHANGE
-- ============================
CREATE TABLE passwords_change (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL,

    change_date TIMESTAMP DEFAULT NOW(),

    token           VARCHAR(200),
    phone_send      VARCHAR(50),
    email_send      VARCHAR(150),

    old_password    VARCHAR(255),
    new_password    VARCHAR(255),

    CONSTRAINT fk_password_user FOREIGN KEY (user_id)
        REFERENCES users(id) ON DELETE CASCADE
);


-- ============================
--  ACCESS (login history)
-- ============================
CREATE TABLE access (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL,

    login_date TIMESTAMP DEFAULT NOW(),
    ip VARCHAR(50),

    CONSTRAINT fk_access_user FOREIGN KEY (user_id)
        REFERENCES users(id) ON DELETE CASCADE
);

CREATE INDEX idx_access_user_id ON access(user_id);
