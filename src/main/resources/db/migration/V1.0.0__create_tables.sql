-- Vehicle Table
CREATE TABLE public.vehicles (
	id varchar(10) NOT NULL,
	brand varchar(50) NOT NULL,
	color varchar(50) NOT NULL,
	created_at timestamptz(6) NOT NULL,
	model varchar(100) NOT NULL,
	price numeric(38, 2) NOT NULL,
	status int4 NOT NULL,
	"type" int4 NOT NULL,
	updated_at timestamptz(6) NOT NULL,
	"year" int4 NOT NULL,
	CONSTRAINT vehicles_pkey PRIMARY KEY (id)
);

-- Transactions Table
CREATE TABLE public.transactions (
	id varchar(36) NOT NULL,
	buyer_id varchar(36) NOT NULL,
	buyer_name varchar(60) NOT NULL,
	created_at timestamptz(6) NOT NULL,
	status int4 NOT NULL,
	updated_at timestamptz(6) NOT NULL,
	value numeric(38, 2) NOT NULL,
	vehicle_brand varchar(50) NOT NULL,
	vehicle_id varchar(10) NOT NULL,
	vehicle_model varchar(100) NOT NULL,
	CONSTRAINT transactions_pkey PRIMARY KEY (id)
);

-- Sequence sale_id
CREATE SEQUENCE public.sale_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 999999
	START 1
	CACHE 1
	NO CYCLE;