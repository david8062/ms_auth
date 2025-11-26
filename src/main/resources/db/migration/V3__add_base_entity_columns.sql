-- ============================
-- ADD base entity fields to USERS
-- ============================

ALTER TABLE users
ADD COLUMN IF NOT EXISTS active BOOLEAN DEFAULT TRUE;

-- Opcional si tu BaseEntity tiene status
-- ALTER TABLE users ADD COLUMN IF NOT EXISTS status VARCHAR(20);

ALTER TABLE users
ALTER COLUMN updated_at SET DEFAULT NOW();


-- ============================
-- ADD base entity fields to PASSWORDS_CHANGE
-- ============================

ALTER TABLE passwords_change
ADD COLUMN IF NOT EXISTS created_at TIMESTAMP DEFAULT NOW(),
ADD COLUMN IF NOT EXISTS updated_at TIMESTAMP DEFAULT NOW(),
ADD COLUMN IF NOT EXISTS active BOOLEAN DEFAULT TRUE;


-- ============================
-- ADD base entity fields to ACCESS
-- ============================

ALTER TABLE access
ADD COLUMN IF NOT EXISTS created_at TIMESTAMP DEFAULT NOW(),
ADD COLUMN IF NOT EXISTS updated_at TIMESTAMP DEFAULT NOW(),
ADD COLUMN IF NOT EXISTS active BOOLEAN DEFAULT TRUE;
