CREATE TABLE IF NOT EXISTS `tbl_person` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `first_name` varchar(80) NOT NULL,
   `last_name` varchar(100) NOT NULL,   
   `address` varchar(150) NOT NULL,
   `gender` varchar(6) NOT NULL,  
  PRIMARY KEY (`id`)
) ; 