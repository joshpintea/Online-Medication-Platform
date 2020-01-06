insert into user values (1, 'josh', now(), 'M', 'josh', 'josh', 'ROLE_DOCTOR', 'josh');
insert into user values (2, 'patient', now(), 'M', 'patient', 'patient', 'ROLE_PATIENT', 'patient');
insert into user values (3, 'caregiver', now(), 'M', 'caregiver', 'caregiver', 'ROLE_CAREGIVER', 'caregiver');

insert into doctor values (1);
insert into caregiver values (3);
insert into patient values (2, 3);