CREATE SEQUENCE cidade_seq;
CREATE SEQUENCE anuncio_seq;
CREATE SEQUENCE produto_seq;
CREATE SEQUENCE usuario_seq;

CREATE TABLE public.uf 
(
    uf character varying(255) COLLATE pg_catalog."default" NOT NULL,
    nome character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT uf_pkey PRIMARY KEY (uf)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.uf
    OWNER to postgres;

-- Table: public.cidade

-- DROP TABLE public.cidade;

CREATE TABLE public.cidade
(
    id bigint NOT NULL,
    nome character varying(255) COLLATE pg_catalog."default" NOT NULL,
    uf_id character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT cidade_pkey PRIMARY KEY (id),
    CONSTRAINT fk_cidade_uf_id FOREIGN KEY (uf_id)
        REFERENCES public.uf (uf) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.cidade
    OWNER to postgres;

-- Table: public.categoria

-- DROP TABLE public.categoria;

CREATE TABLE public.categoria
(
    id bigint NOT NULL,
    nome character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT categoria_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.categoria
    OWNER to postgres;

-- Table: public.usuario

-- DROP TABLE public.usuario;

CREATE TABLE public.usuario
(
    id bigint NOT NULL,
    bairro character varying(255) COLLATE pg_catalog."default",
    cep character varying(255) COLLATE pg_catalog."default",
    cpf character varying(255) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    logradouro character varying(255) COLLATE pg_catalog."default",
    nome character varying(255) COLLATE pg_catalog."default",
    senha character varying(255) COLLATE pg_catalog."default",
    telefone character varying(255) COLLATE pg_catalog."default",
    cidade_id bigint,
    CONSTRAINT usuario_pkey PRIMARY KEY (id),
    CONSTRAINT fk_usuario_cidade_id FOREIGN KEY (cidade_id)
        REFERENCES public.cidade (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.usuario
    OWNER to postgres;

-- Table: public.produto

-- DROP TABLE public.produto;

CREATE TABLE public.produto
(
    id bigint NOT NULL,
    bairro character varying(255) COLLATE pg_catalog."default" NOT NULL,
    cep character varying(10) COLLATE pg_catalog."default" NOT NULL,
    descricao character varying(255) COLLATE pg_catalog."default" NOT NULL,
    finalidade character varying(255) COLLATE pg_catalog."default",
    logradouro character varying(255) COLLATE pg_catalog."default",
    nome character varying(255) COLLATE pg_catalog."default" NOT NULL,
    valor double precision,
    categoria_id bigint,
    cidade_id bigint,
    CONSTRAINT produto_pkey PRIMARY KEY (id),
    CONSTRAINT fk_produto_categoria_id FOREIGN KEY (categoria_id)
        REFERENCES public.categoria (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_produto_cidade_id FOREIGN KEY (cidade_id)
        REFERENCES public.cidade (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.produto
    OWNER to postgres;

-- Table: public.anuncio

-- DROP TABLE public.anuncio;

CREATE TABLE public.anuncio
(
    id bigint NOT NULL,
    quando character varying(255) COLLATE pg_catalog."default",
    usuario_id bigint,
    produto_id bigint,
    CONSTRAINT anuncio_pkey PRIMARY KEY (id),
    CONSTRAINT fk_anuncio_produto_id FOREIGN KEY (produto_id)
        REFERENCES public.produto (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_anuncio_usuario_id FOREIGN KEY (usuario_id)
        REFERENCES public.usuario (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.anuncio
    OWNER to postgres;