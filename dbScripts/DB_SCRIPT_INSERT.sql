INSERT INTO `outreach_vfs`.`location`
(`city`, `state`, `country`)
VALUES
('Coimbatore','Tamil Nadu','India'),
('Kolkata','West Bengal','India');

INSERT INTO `outreach_vfs`.`business_unit`
(`buss_unit_name`, `location_id`)
VALUE
('Insurance-CCC',1),
('Insurance-KNC',2);

INSERT INTO `outreach_vfs`.`event_beneficiary`
(`description`)
VALUES
('KMCH Group of Hospitals'),
('OOTY Higher Secondary School');

INSERT INTO `outreach_vfs`.`event_council`
(`council_name`,`location_id`)
VALUES
('COUNCIL ABC', 1),
('COUNCIL DEF', 2);

INSERT INTO `outreach_vfs`.`role_lookup`
(`description`)
VALUES
('Admin'), ('POC'), ('Volunteer');

INSERT INTO `outreach_vfs`.`feedback_options`
(`description`)
VALUES
('Unexpected Family commitment'),('Unexpected official work'),
('Event was not what I expected'),('Didnot recieve further information about event'),
('Incorrectly registered'),('Donot wish to disclose');

INSERT INTO `outreach_vfs`.`rating`
(`description`)
VALUES
('Very Good'), ('Good'), ('Neutral'), ('Poor'), ('Very Poor');

INSERT INTO `outreach_vfs`.`iiep_category`
(`description`)
VALUES
('IIEP 1'), ('IIEP 2'), ('IIEP 3'), ('IIEP 4'), ('IIEP 5');


INSERT INTO `outreach_vfs`.`status`
(`description`)
VALUES
('Active'), ('Unregistered'), ('Registered'), ('Failed To Attend'), ('Completed'), ('Attended'), ('Yet To Send Mail'), ('Attended'), ('Pending'), ('Submitted'), ('Mail Sent');

INSERT INTO `outreach_vfs`.`project`
(`description`)
VALUES
('Donation or Distribution'), ('Be a Teacher'), ('Community Program');

INSERT INTO `outreach_vfs`.`category`
(`description`)
VALUES
('Essentials or relief'), ('Multiple Subjects'), ('Other Community Programs'), ('English'), ('Other Subject');

INSERT INTO `outreach_vfs`.`employee`
(`employee_id`,
`emp_first_name`,
`emp_last_name`,
`emp_email`,
`Contact`,
`emp_location_id`,
`business_unit_id`,
`evnt_volunteer_hours`,
`role_id`,
`password`,
`employee_status_id`)
VALUES
(512642,
'Admin', '', ' logeshtips@gmail.com','8056245629',1,1,8,1,'admin',1),
(512641,
'Logeshwara', 'Raja K', ' 512641@cognizant.com','8056245629',1,1,8,2,'logesh',1),
(512643,
'Logeshwara', 'Raja K', ' logeshwararaja.k@cognizant.com','8056245629',1,1,8,3,null,1);

INSERT INTO `outreach_vfs`.`event`
(`id`,`month`,`evnt_base_location_id`,`evnt_benef_id`,
`evnt_name`,
`venue_address`,
`project_id`,
`category_id`,
`evnt_description`,
`evnt_date`,
`event_poc's`,
`total_volunteers`,
`total_volunteer_hrs`,
`total_travel_hrs`,
`overall_volunteer_hrs`,
`lives_impacted`,
`iiep_category_id`,
`event_council_id`,
`created_by_id`)
VALUES
('EVENT0001', 'JAN',1,2,'Donations','705, Serangoon Road, Singapore, Singapore, Singapore-328127',
1,1,'Teach various subjects to the students in Kamarajar Illam',current_date(),'512641,512645',
10,20,10,30,100,4,1,519847),
('EVENT0002', 'FEB',2,2,'Be A teacher','705, Serangoon Road, Singapore, Singapore, Singapore-328127',
2,2,'Teach various subjects to the students in Kamarajar Illam',current_date(),'512646,512647',
10,20,10,30,100,4,1,519847);

INSERT INTO `outreach_vfs`.`event_details`
(`evnt_id`,`employee_id`,`volunteer_hrs`,`travel_hrs`,`participation_status_id`,
`feedback_status_id`,`created_by_id`)
VALUES
('EVENT0001',512641,2,1,2,7,512641),
('EVENT0001',512641,2,1,4,7,512641),
('EVENT0001',512641,2,1,6,11,512641),
('EVENT0001',512641,2,1,2,10,512641),
('EVENT0001',512641,2,1,4,10,512641),
('EVENT0001',512641,2,1,6,10,512641);

INSERT INTO `outreach_vfs`.`event_details`
(`evnt_id`,`employee_id`,`volunteer_hrs`,`travel_hrs`,`participation_status_id`,
`feedback_status_id`,`created_by_id`)
VALUES
('EVENT0002',512641,2,1,2,7,512641),
('EVENT0002',512641,2,1,4,7,512641),
('EVENT0002',512641,2,1,6,11,512641),
('EVENT0002',512641,2,1,2,10,512641),
('EVENT0002',512641,2,1,4,10,512641),
('EVENT0002',512641,2,1,6,10,512641);


INSERT INTO `outreach_vfs`.`feedback`
(`event_detail_id`,`rating`,`feedback_option_id`,`like_feedback`,`improve_feedback`,`admin_feedback`,
`update_id`)
VALUES
(4,1,1,'Enjoyed it','Food Taste','Looking into it', 512641),
(5,2,2,'Enjoyed it','Food Taste','Looking into it', 512641),
(6,3,3,'Enjoyed it','Food Taste','Looking into it', 512641),
(10,2,2,'Enjoyed it','Food Taste','Looking into it', 512641),
(11,3,3,'Enjoyed it','Food Taste','Looking into it', 512641),
(12,4,4,'Enjoyed it','Food Taste','Looking into it', 512641);
