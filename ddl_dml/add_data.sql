BEGIN;

INSERT INTO "merge_item" ("name", "parent_id", "is_root") VALUES
('Minuscule truc', null, TRUE),
('Petit truc', 1, FALSE),
('Moyen truc', 2, FALSE),
('Gros truc', 3, FALSE),
('Giga truc', 4, FALSE);

INSERT INTO "merge_item" ("name", "parent_id", "number_owned", "is_root") VALUES
('Chaton', null, 15, TRUE),
('Chat', 5, 8, FALSE),
('Tigre', 6, 2, FALSE),
('Panthère géante', 7, 1, FALSE);

COMMIT;