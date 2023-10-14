BEGIN;

DROP TABLE IF EXISTS
    "merge_item";

CREATE TABLE IF NOT EXISTS "merge_item" (
    "id" serial PRIMARY KEY,
    "name" TEXT NOT NULL UNIQUE,
    "parent_id" INTEGER UNIQUE REFERENCES "merge_item" ("id"),
    "number_owned" INTEGER NOT NULL DEFAULT 0,
    "is_root" BOOLEAN NOT NULL
);

COMMIT;