INSERT INTO utilisateur (email, password, administrateur) VALUES
                                                              ("a@a.com", "$2a$10$KIp0gvyA4WJO.EtUtJYUr.Dn8oJAZUh7g7FV9.c3uEpV4ozbo5a1e", 0) ,
                                                              ("b@b.com", "$2a$10$KIp0gvyA4WJO.EtUtJYUr.Dn8oJAZUh7g7FV9.c3uEpV4ozbo5a1e", 1 ) ,
                                                              ("c@c.com", "$2a$10$KIp0gvyA4WJO.EtUtJYUr.Dn8oJAZUh7g7FV9.c3uEpV4ozbo5a1e", 0 );

INSERT INTO quizz (nom, niveau, createur_id) VALUES
                                                 ("pokemon", 1, 1 ) ,
                                                 ("manga", 3, 1 ) ,
                                                 ("serie 90", 4, 2 );

INSERT INTO categorie (nom) VALUES
                                ("Culture G"),
                                ("Culture geek"),
                                ("Geographie"),
                                ("Japon"),
                                ("Serie");

INSERT INTO categorie_quizz (quizz_id, categorie_id) VALUES
                                                         (1, 2),
                                                         (1, 4),
                                                         (1, 5),
                                                         (2, 2),
                                                         (1, 2);

-- INSERT INTO question (nom)
-- VALUES
-- ("JJJ?"),
-- ("Culture geek ?"),
-- ("Geographie ?"),
-- ("Japon ?"),
-- ("Serie ?");

INSERT INTO question (texte, quizz_id)
VALUES
    ("citez un peintre de la renaissance ?", 1),
    ("quelle est la couleur du ciel ?", 1);

INSERT INTO reponse_possible (texte, juste, question_id) VALUES
("PICASSO", 0, 1),
("DE VINCI", 0, 1),
("MC DO", 1, 1),
("BLANC", 0, 2),
("JAUNE", 0, 2),
("BLEU", 1, 2);

INSERT INTO  reponse_utilisateur (reponse_possible_id, repondeur_id) VALUES
(2, 1),
(1, 3);

-- INSERT INTO question_quizz (quizz_id, question_id)
-- VALUES
--  (1, 2),
--  (2, 4),
--  (3, 5),
--  (3, 3),
--  (2, 1);
