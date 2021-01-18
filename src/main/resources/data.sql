-- branches
INSERT INTO `vacc_now`.`branch` (`NAME`, `AVAILABLE_VACCINES`) VALUES ('Nasr-City', 1200);
INSERT INTO `vacc_now`.`branch` (`NAME`, `AVAILABLE_VACCINES`) VALUES ('Haram', 400);
INSERT INTO `vacc_now`.`branch` (`NAME`, `AVAILABLE_VACCINES`) VALUES ('down-town', 600);
INSERT INTO `vacc_now`.`branch` (`NAME`, `AVAILABLE_VACCINES`) VALUES ('Maadi', 1200);
-- time-schedule
INSERT INTO `vacc_now`.`time_schedule` (`START`, `END`, `BRANCH_ID`) VALUES (1611039600000, 1611040500000, 1);
INSERT INTO `vacc_now`.`time_schedule` (`START`, `END`, `BRANCH_ID`) VALUES (1611041400000, 1611042300000, 1);
INSERT INTO `vacc_now`.`time_schedule` (`START`, `END`, `BRANCH_ID`) VALUES (1611039600000, 1611040500000, 2);
INSERT INTO `vacc_now`.`time_schedule` (`START`, `END`, `BRANCH_ID`) VALUES (1611041400000, 1611042300000, 2);
INSERT INTO `vacc_now`.`time_schedule` (`START`, `END`, `BRANCH_ID`) VALUES (1611039600000, 1611040500000, 4);
INSERT INTO `vacc_now`.`time_schedule` (`START`, `END`, `BRANCH_ID`) VALUES (1611041400000, 1611042300000, 4);
-- clients
INSERT INTO `vacc_now`.`client` (`NAME`, `EMAIL`) VALUES ('muhammad', 'muhammadmokhtar92@gmail.com');
INSERT INTO `vacc_now`.`client` (`NAME`, `EMAIL`) VALUES ('ahmed', 'ahmedalikelay@hotmail.com');
INSERT INTO `vacc_now`.`client` (`NAME`, `EMAIL`) VALUES ('hassan', 'hassansaied@yahoo.com');
INSERT INTO `vacc_now`.`client` (`NAME`, `EMAIL`) VALUES ('mostafa', 'mostafasayed@outlook.com');
INSERT INTO `vacc_now`.`client` (`NAME`, `EMAIL`) VALUES ('mahmoud', 'mahmoudhanafy@corporate.com');
-- payment-methods
INSERT INTO `vacc_now`.`payment_method` (`NAME`) VALUES ('CASH');
INSERT INTO `vacc_now`.`payment_method` (`NAME`) VALUES ('CREDIT');
INSERT INTO `vacc_now`.`payment_method` (`NAME`) VALUES ('FAWRY');