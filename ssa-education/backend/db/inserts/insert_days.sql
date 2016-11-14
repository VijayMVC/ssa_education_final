delete from days;

-- insert into days

-- all 6 combinations of choosing 1 day
insert into days (days) values ("M");
insert into days (days) values ("T");
insert into days (days) values ("W");
insert into days (days) values ("R");
insert into days (days) values ("F");
insert into days (days) values ("S");

-- all 15 combinations of choosing 2 days
insert into days (days) values ("M,T");
insert into days (days) values ("M,W");
insert into days (days) values ("M,R");
insert into days (days) values ("M,F");
insert into days (days) values ("M,S");
insert into days (days) values ("T,W");
insert into days (days) values ("T,R");
insert into days (days) values ("T,F");
insert into days (days) values ("T,S");
insert into days (days) values ("W,R");
insert into days (days) values ("W,F");
insert into days (days) values ("W,S");
insert into days (days) values ("R,F");
insert into days (days) values ("R,S");
insert into days (days) values ("R,S");

-- all 20 combinations of choosing 3 days
insert into days (days) values ("M,T,W");

-- all 15 combinations of choosing 4 days
insert into days (days) values ("M,T,W,R");
insert into days (days) values ("M,T,W,F");
insert into days (days) values ("M,T,W,S");
insert into days (days) values ("M,T,R,F");
insert into days (days) values ("M,T,R,S");
insert into days (days) values ("M,T,F,S");
insert into days (days) values ("M,W,R,F");
insert into days (days) values ("M,W,R,S");
insert into days (days) values ("M,W,F,S");
insert into days (days) values ("M,R,F,S");
insert into days (days) values ("T,W,R,F");
insert into days (days) values ("T,W,R,S");
insert into days (days) values ("T,W,F,S");
insert into days (days) values ("T,R,F,S");
insert into days (days) values ("W,R,F,S");

-- all 6 combinations of choosing 5 days
insert into days (days) values ("M,T,W,R,F");
insert into days (days) values ("M,T,W,R,S");
insert into days (days) values ("M,T,W,F,S");
insert into days (days) values ("M,T,R,F,S");
insert into days (days) values ("M,W,R,F,S");
insert into days (days) values ("T,W,R,F,S");


-- the 1 combination of choosing 6 days
insert into days (days) values ("M,T,W,R,F,S");
