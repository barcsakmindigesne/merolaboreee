/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  HEM6MC
 * Created: Jun 1, 2018
 */

INSERT INTO dolgozo (eletkor, nev) VALUES (51, 'Nagy Imre');
INSERT INTO dolgozo (eletkor, nev) VALUES (23, 'Erdei Tamas');
INSERT INTO dolgozo (eletkor, nev) VALUES (44, 'Kiss Csilla');
INSERT INTO dolgozo (eletkor, nev) VALUES (34, 'Fekete Daniel');
INSERT INTO dolgozo (eletkor, nev) VALUES (29, 'Szucs Pal');



INSERT INTO eszkoz (eszkoznev) VALUES ('Kis merleg');
INSERT INTO eszkoz (eszkoznev) VALUES ('Nagy merleg');
INSERT INTO eszkoz (eszkoznev) VALUES ('Tolomero kicsi');
INSERT INTO eszkoz (eszkoznev) VALUES ('Tolomero nagy');
INSERT INTO eszkoz (eszkoznev) VALUES ('Meroszalag');


INSERT INTO meres (alkatreszszam, hossz, idopont, suly, dolgozo_id) VALUES ('L34T4M', 12, NOW(), 5, 1);
INSERT INTO meres (alkatreszszam, hossz, idopont, suly, dolgozo_id) VALUES ('L24Z6M', 10, NOW(), 7, 2);
INSERT INTO meres (alkatreszszam, hossz, idopont, suly, dolgozo_id) VALUES ('K55Z3M', 17, NOW(), 8, 1);

INSERT INTO dolgozo_eszkoz (eszkoz_id, dolgozo_id) VALUES (1, 1);
INSERT INTO dolgozo_eszkoz (eszkoz_id, dolgozo_id) VALUES (1, 2);
INSERT INTO dolgozo_eszkoz (eszkoz_id, dolgozo_id) VALUES (1, 3);
INSERT INTO dolgozo_eszkoz (eszkoz_id, dolgozo_id) VALUES (2, 1);
INSERT INTO dolgozo_eszkoz (eszkoz_id, dolgozo_id) VALUES (2, 2);
INSERT INTO dolgozo_eszkoz (eszkoz_id, dolgozo_id) VALUES (3, 4);
INSERT INTO dolgozo_eszkoz (eszkoz_id, dolgozo_id) VALUES (4, 4);
INSERT INTO dolgozo_eszkoz (eszkoz_id, dolgozo_id) VALUES (5, 5);