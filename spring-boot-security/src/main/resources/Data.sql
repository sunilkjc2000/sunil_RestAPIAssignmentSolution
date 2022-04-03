-- Insert data into EMPLOYEE Table
 INSERT INTO Employee VALUES (1, 'sunilk@greatleanring.com','sunil','kumar');
 INSERT INTO Employee VALUES (2, 'sunil','kum','sunilkum@greatleanring.com');
 INSERT INTO Employee VALUES (3, 'Rajesh','ratan','rajeshRatan@greatleanring.com');
 
 -- select * from lms.roles;
  insert into roles values (1,'ADMIN');
  insert into roles values (2,'USER');

-- Change encrypted value to the password that you want to use to login - https://bcrypt-generator.com/

  insert into users values(1,'$2a$12$H0CqM1RPKChrIDDYyCcKy.Q1tXpDKdU5k9sF2Y4BJgCm2NIrRycMa','admin');
  insert into users values(2,'$2a$12$306CW6IeGPGM.sTmcW0nNeXRAV2TjZvh2yFiT3GA97Uic5Gw6nOGq','sunil');

  insert into users_roles values(1,1);
  insert into users_roles values(2,2);







