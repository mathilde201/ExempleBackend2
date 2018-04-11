INSERT INTO `user` (`TYPE_USER`, `id`, `email`, `mdp`, `nom`, `numTel`, `prenom`, `sexe`, `username`, `dateDebutContat`, `matricule`, `matrimonial`, `nbEnfant`) VALUES ('admin', '1', 'admin@ban.fr', 'mdp', 'Browning', '1234567890', 'Emily', 'f', 'BabyDoll', '2017-08-07 00:00:00', 'ADM001', NULL, 0);

INSERT INTO `user` (`TYPE_USER`, `id`, `email`, `mdp`, `nom`, `numTel`, `prenom`, `sexe`, `username`, `dateDebutContat`, `matricule`, `matrimonial`, `nbEnfant`) VALUES ('agent', '10', 'agent@bam.fr', 'mdp', 'Depp', '2345678901', 'Johnny', 'm', 'JackSparrow', '2018-02-06 00:00:00', 'AGE010', NULL, 0);
INSERT INTO `user` (`TYPE_USER`, `id`, `email`, `mdp`, `nom`, `numTel`, `prenom`, `sexe`, `username`, `dateDebutContat`, `matricule`, `matrimonial`, `nbEnfant`) VALUES ('agent', '11', 'agent@bam.fr', 'mdp', 'Cruise', '2345678901', 'Tom', 'm', 'MissionImpossible', '1970-02-05 00:00:00', 'AGE011', NULL, 0);

INSERT INTO `user` (`TYPE_USER`, `id`, `email`, `mdp`, `nom`, `numTel`, `prenom`, `sexe`, `username`, `dateDebutContat`, `matricule`, `matrimonial`, `nbEnfant`) VALUES ('client', '100', 'client@bam.ft', 'mdp', 'Chaplin', '3456789012', 'Charlie', 'm', 'CC', '2018-01-23 00:00:00', NULL, NULL, 0);
INSERT INTO `user` (`TYPE_USER`, `id`, `email`, `mdp`, `nom`, `numTel`, `prenom`, `sexe`, `username`, `dateDebutContat`, `matricule`, `matrimonial`, `nbEnfant`) VALUES ('client', '101', 'client2@bam.fr', 'mdp', 'Kunis', '4567890123', 'Mila', 'f', 'Lori', '2018-04-16 00:00:00', 'CLIE002', NULL, '2');


INSERT INTO `user_user` (`user_id`, `users_id`) VALUES ('1', '10');
INSERT INTO `user_user` (`user_id`, `users_id`) VALUES ('10', '100'),('10', '101');



INSERT INTO `visiteur` (`id`, `dateNaissance`, `email`, `nom`, `prenom`) VALUES (1000, '2018-04-08 00:00:00', 'Bernadette@bern.at', 'Bern', 'Bernadette');
INSERT INTO `visiteur` (`id`, `dateNaissance`, `email`, `nom`, `prenom`) VALUES (1001, '1980-01-08 16:00:18', 'Fried@lan.de', 'Friedlander', 'Friedrich');
