CREATE TABLE IF NOT EXISTS Citizenship
(
    id      INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version INTEGER             NOT NULL COMMENT 'Служебное поле hibernate',
    name    VARCHAR(255) UNIQUE NOT NULL COMMENT 'Наименование',
    code    INTEGER UNIQUE      NOT NULL COMMENT 'Код'
);
CREATE INDEX IX_Citizenship_code ON Citizenship (code);
CREATE UNIQUE INDEX IX_Citizenship_name ON Citizenship (name);

COMMENT ON TABLE Citizenship IS 'Таблица гражданства';



CREATE TABLE IF NOT EXISTS Document_type
(
    id      INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version INTEGER             NOT NULL COMMENT 'Служебное поле hibernate',
    name    VARCHAR(255) UNIQUE NOT NULL COMMENT 'Наименование',
    code    SMALLINT UNIQUE     NOT NULL COMMENT 'Код'
);
CREATE UNIQUE INDEX IX_Document_type_name ON Document_type (name);
CREATE INDEX IX_Document_type_code ON Document_type (code);

COMMENT ON TABLE Document_type IS 'Таблица типов документов';



CREATE TABLE IF NOT EXISTS Document
(
    id               INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version          INTEGER            NOT NULL COMMENT 'Служебное поле hibernate',
    document_type_id INTEGER            NOT NULL COMMENT 'Внешний ключ на таблицу типов документов',
    number           VARCHAR(20)        NOT NULL COMMENT 'Номер',
    date             DATE DEFAULT NOW() NOT NULL COMMENT 'Дата',
    FOREIGN KEY (document_type_id) REFERENCES Document_type (id)
);
CREATE INDEX IX_Document_number_date ON Document (number, date);
CREATE INDEX IX_Document_document_type_id ON Document (document_type_id);

COMMENT ON TABLE Document IS 'Таблица документов удостоверяющих личность';



CREATE TABLE IF NOT EXISTS Organization
(
    id        INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version   INTEGER      NOT NULL COMMENT 'Служебное поле hibernate',
    name      VARCHAR(255) NOT NULL COMMENT 'Краткое наименование',
    full_name VARCHAR(255) NOT NULL COMMENT 'Полное наименование',
    inn       VARCHAR(12)  NOT NULL COMMENT 'ИНН',
    kpp       VARCHAR(9)   NOT NULL COMMENT 'КПП',
    address   VARCHAR(255) NOT NULL COMMENT 'Адрес организации',
    phone     VARCHAR(11) COMMENT 'Номер телефона',
    is_active BOOL COMMENT 'Флаг использования'
);
CREATE INDEX IX_Organization_name ON Organization (name);
CREATE INDEX IX_Organization_inn ON Organization (inn);
CREATE INDEX IX_Organization_phone ON Organization (phone);

COMMENT ON TABLE Organization IS 'Организация';



CREATE TABLE IF NOT EXISTS Office
(
    id              INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version         INTEGER NOT NULL COMMENT 'Служебное поле hibernate',
    organization_id INTEGER COMMENT 'Внешний ключ на таблицу организации',
    name            VARCHAR(255) COMMENT 'Наименование',
    address         VARCHAR(255) COMMENT 'Адрес офиса',
    phone           VARCHAR(11) COMMENT 'Номер телефона',
    is_active       BOOL COMMENT 'Флаг использования',
    FOREIGN KEY (organization_id) REFERENCES Organization (id)
);
CREATE INDEX IX_Office_name ON Office (name);
CREATE INDEX IX_Office_phone ON Office (phone);
CREATE INDEX IX_Office_organization_id ON Office (organization_id);

COMMENT ON TABLE Office IS 'Офис организации';



CREATE TABLE IF NOT EXISTS Position
(
    id      INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version INTEGER             NOT NULL COMMENT 'Служебное поле hibernate',
    name    VARCHAR(255) UNIQUE NOT NULL COMMENT 'Наименование'
);
CREATE UNIQUE INDEX IX_position_name ON Position (name);

COMMENT ON TABLE Position IS 'Таблица должностей';



CREATE TABLE IF NOT EXISTS User
(
    id             INTEGER COMMENT 'Уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT,
    version        INTEGER     NOT NULL COMMENT 'Служебное поле hibernate',
    office_id      INTEGER     NOT NULL COMMENT 'Внешний ключ на таблицу офис',
    first_name     VARCHAR(50) NOT NULL COMMENT 'Имя',
    second_name    VARCHAR(50) COMMENT 'Фамилия',
    middle_name    VARCHAR(50) COMMENT 'Отчество',
    phone          VARCHAR(11) COMMENT 'Телефон',
    position_id    INTEGER     NOT NULL COMMENT 'Внешний ключ на таблицу должности',
    document_id    INTEGER UNIQUE COMMENT 'Внешний ключ на таблицу документов',
    citizenship_id INTEGER COMMENT 'Внешний ключ на таблицу гражданства',
    is_identified  BOOL COMMENT 'Флаг идентифицирован',
    FOREIGN KEY (position_id) REFERENCES Position (id),
    FOREIGN KEY (citizenship_id) REFERENCES Citizenship (id),
    FOREIGN KEY (document_id) REFERENCES Document (id)
);
CREATE INDEX IX_User_first_name ON User (first_name);
CREATE INDEX IX_User_second_name ON User (second_name);
CREATE INDEX IX_User_phone ON User (phone);
CREATE INDEX IX_User_office_id ON User (office_id);
CREATE INDEX IX_User_position_id ON User (position_id);
CREATE INDEX IX_User_citizenship_id ON User (citizenship_id);
CREATE UNIQUE INDEX IX_User_document_id ON User (document_id);

COMMENT ON TABLE User IS 'Человек';