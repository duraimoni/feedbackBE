ALTER TABLE  `app_user` DROP FOREIGN KEY  `app_user_ibfk_3` ;

ALTER TABLE  `product` ADD FOREIGN KEY (  `domain_id` ) REFERENCES  `feedback`.`domain` (
`domain_id`
) ON DELETE RESTRICT ON UPDATE RESTRICT ;

ALTER TABLE  `domain` ADD FOREIGN KEY (  `domain_leader` ) REFERENCES  `feedback`.`user` (
`user_id`
) ON DELETE RESTRICT ON UPDATE RESTRICT ;