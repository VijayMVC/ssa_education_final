delete from prerequisites;

-- insert into prerequisites

-- ACCT 101 = no prereqs
-- ACCT 102 = (ACCT 101)
insert into prerequisites (class_id, prereq_class_id) values (2,1);

-- ACCT 104 = (ACCT 101)
insert into prerequisites (class_id, prereq_class_id) values (3,1);

-- ACCT 105 = (ACCT 101)
insert into prerequisites (class_id, prereq_class_id) values (4,1);

-- ACCT 107 = (ACCT 101, CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (5,1);
insert into prerequisites (class_id, prereq_class_id) values (5,98);

-- ACCT 108 = (ACCT 101)
insert into prerequisites (class_id, prereq_class_id) values (6,1);

-- ACCT 203 = (ACCT 101)
insert into prerequisites (class_id, prereq_class_id) values (7,1);

-- ACCT 204 = (ACCT 203)
insert into prerequisites (class_id, prereq_class_id) values (8,7);

-- ACCT 205 = (ACCT 102)
insert into prerequisites (class_id, prereq_class_id) values (9,2);

-- ACCT 206 = (ACCT 102)
insert into prerequisites (class_id, prereq_class_id) values (10,2);

-- ACCT 208 = (ACCT 101)
insert into prerequisites (class_id, prereq_class_id) values (11,1);

-- ACCT 210 = (ACCT 101)
insert into prerequisites (class_id, prereq_class_id) values (12,1);

-- ACCT 211 = (ACCT 102)
insert into prerequisites (class_id, prereq_class_id) values (13,2);

-- ACCT 212 = (ACCT 211)
insert into prerequisites (class_id, prereq_class_id) values (14,13);

-- ACCT 263 = (ACCT 102)
insert into prerequisites (class_id, prereq_class_id) values (15,2);

-- ACCT 271 = no prereqs
-- ACCT 272 = no prereqs
-- ACCT 273 = no prereqs
-- ACCT 274 = no prereqs

-- BIO 099 = no prereqs
-- BIO 100 = no prereqs
-- BIO 107 = (BIO 120)
insert into prerequisites (class_id, prereq_class_id) values (22,28);

-- BIO 108 = no prereqs
-- BIO 109 = no prereqs
-- BIO 110 = no prereqs
-- BIO 116 = no prereqs

-- BIO 119 = no prereqs
-- BIO 120 = no prereqs
-- BIO 121 = (BIO 120)
insert into prerequisites (class_id, prereq_class_id) values (29,28);

-- BIO 124 = (CHEM 111)
insert into prerequisites (class_id, prereq_class_id) values (30,84);

-- BIO 125 = (BIO 124)
insert into prerequisites (class_id, prereq_class_id) values (31,30);

-- BIO 126 = (BIO 125)
insert into prerequisites (class_id, prereq_class_id) values (32,31);

-- BIO 127 = (BIO 124)
insert into prerequisites (class_id, prereq_class_id) values (33,30);

-- BIO 191 = (BIO 120)
insert into prerequisites (class_id, prereq_class_id) values (34,28);

-- BIO 192 = (BIO 120)
insert into prerequisites (class_id, prereq_class_id) values (35,28);

-- BIO 202 = (BIO 121)
insert into prerequisites (class_id, prereq_class_id) values (36,29);

-- BIO 203 = (BIO 120)
insert into prerequisites (class_id, prereq_class_id) values (37,28);

-- BIO 204 = (BIO 203)
insert into prerequisites (class_id, prereq_class_id) values (38,37);

-- BIO 205 = (BIO 203)
insert into prerequisites (class_id, prereq_class_id) values (39,37);

-- BIO 208 = (BIO 120)
insert into prerequisites (class_id, prereq_class_id) values (40,28);

-- BIO 210 = (BIO 203)
insert into prerequisites (class_id, prereq_class_id) values (41,37);

-- BIO 271 = (BIO 120)
insert into prerequisites (class_id, prereq_class_id) values (42,28);

-- BIO 272 = (BIO 271)
insert into prerequisites (class_id, prereq_class_id) values (43,42);

-- BIO 273 = (BIO 272)
insert into prerequisites (class_id, prereq_class_id) values (44,43);

-- BIO 274 = (BIO 273)
insert into prerequisites (class_id, prereq_class_id) values (45,44);

-- BA 101 = no prereqs
-- BA 103 = no prereqs
-- BA 104 = no prereqs
-- BA 105 = no prereqs

-- BA 106 = no prereqs
-- BA 107 = no prereqs
-- BA 108 = no prereqs

-- BA 109 = (BA 101)
insert into prerequisites (class_id, prereq_class_id) values (53,46);

-- BA 110 = no prereqs
-- BA 111 = no prereqs
-- BA 112 = no prereqs
-- BA 113 = no prereqs
-- BA 115 = no prereqs

-- BA 116 = no prereqs
-- BA 117 = no prereqs

-- BA 130 = (BA 101)
insert into prerequisites (class_id, prereq_class_id) values (61,46);

-- BA 140 = no prereqs
-- BA 145 = no prereqs

-- BA 150 = (BA 130)
insert into prerequisites (class_id, prereq_class_id) values (64,61);

-- BA 203 = (BA 101)
insert into prerequisites (class_id, prereq_class_id) values (65,46);

-- BA 205 = (BA 101)
insert into prerequisites (class_id, prereq_class_id) values (66,46);

-- BA 206 = (BA 101)
insert into prerequisites (class_id, prereq_class_id) values (67,46);

-- BA 208 = (BA 106)
insert into prerequisites (class_id, prereq_class_id) values (68,50);

-- BA 209 = (BA 101)
insert into prerequisites (class_id, prereq_class_id) values (69,46);

-- BA 210 = (BA 101, CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (70,46);
insert into prerequisites (class_id, prereq_class_id) values (70,98);

-- BA 212 = (BA 101)
insert into prerequisites (class_id, prereq_class_id) values (71,46);

-- BA 225 = (BA 101)
insert into prerequisites (class_id, prereq_class_id) values (72,46);

-- BA 242 = (BA 101)
insert into prerequisites (class_id, prereq_class_id) values (73,46);

-- BA 244 = (BA 101)
insert into prerequisites (class_id, prereq_class_id) values (74,46);

-- BA 245 = (BA 101)
insert into prerequisites (class_id, prereq_class_id) values (75,46);

-- BA 246 = (BA 101)
insert into prerequisites (class_id, prereq_class_id) values (76,46);

-- BA 263 = (BA 101)
insert into prerequisites (class_id, prereq_class_id) values (77,46);

-- BA 271 = (BA 101)
insert into prerequisites (class_id, prereq_class_id) values (78,46);

-- BA 272 = (BA 271)
insert into prerequisites (class_id, prereq_class_id) values (79,78);

-- BA 273 = (BA 272)
insert into prerequisites (class_id, prereq_class_id) values (80,79);

-- BA 274 = (BA 273)
insert into prerequisites (class_id, prereq_class_id) values (81,80);

-- CHEM 010 = no prereqs
-- CHEM 111 = no prereqs
-- CHEM 112 = (CHEM 111)
insert into prerequisites (class_id, prereq_class_id) values (85,84);

-- CHEM 114 = (CHEM 111)
insert into prerequisites (class_id, prereq_class_id) values (86,84);

-- CHEM 135 = no prereqs
-- CHEM 204 = (CHEM 112)
insert into prerequisites (class_id, prereq_class_id) values (88,85);

-- CHEM 207 = (CHEM 112)
insert into prerequisites (class_id, prereq_class_id) values (89,85);

-- CHEM 208 = (CHEM 207)
insert into prerequisites (class_id, prereq_class_id) values (90,89);

-- CMST 101 = no prereqs
-- CMST 105 = no prereqs
-- CMST 106 = no prereqs
-- CMST 200 = (CMST 101, ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (94,91);
insert into prerequisites (class_id, prereq_class_id) values (94,207);

-- CMST 210 = (CMST 101)
insert into prerequisites (class_id, prereq_class_id) values (95,91);

-- CMST 230 = (CMST 101, ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (96,91);
insert into prerequisites (class_id, prereq_class_id) values (96,207);

-- CIS 011 = no prereqs
-- CIS 102 = no prereqs
-- CIS 104 = (CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (99,98);

-- CIS 106 = no prereqs
-- CIS 110 = (CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (101,98);

-- CIS 111 = (CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (102,98);

-- CIS 113 = (CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (103,98);

-- CIS 114 = (CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (104,98);

-- CIS 115 = no prereqs
-- CIS 116 = (CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (106,98);

-- CIS 117 = (CIS 116)
insert into prerequisites (class_id, prereq_class_id) values (107,106);

-- CIS 118 = (CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (108,98);

-- CIS 119 = (CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (109,98);

-- CIS 125 = (CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (110,98);

-- CIS 135 = (CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (111,98);

-- CIS 136 = (CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (112,98);

-- CIS 145 = no prereqs
-- CIS 161 = no prereqs
-- CIS 162 = (CIS 161)
insert into prerequisites (class_id, prereq_class_id) values (115,114);

-- CIS 184 = (CIS 111)
insert into prerequisites (class_id, prereq_class_id) values (116,102);

-- CIS 201 = (CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (117,98);

-- CIS 202 = (CIS 102, CIS 115)
insert into prerequisites (class_id, prereq_class_id) values (118,98);
insert into prerequisites (class_id, prereq_class_id) values (118,105);

-- CIS 205 = (CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (119,98);

-- CIS 207 = (CIS 205)
insert into prerequisites (class_id, prereq_class_id) values (120,119);

-- CIS 210 = (CIS 135)
insert into prerequisites (class_id, prereq_class_id) values (121,111);

-- CIS 211 = (CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (122,98);

-- CIS 214 = (CIS 119)
insert into prerequisites (class_id, prereq_class_id) values (123,109);

-- CIS 215 = (CIS 214)
insert into prerequisites (class_id, prereq_class_id) values (124,123);

-- CIS 217 = (CIS 115, CIS 136)
insert into prerequisites (class_id, prereq_class_id) values (125,105);
insert into prerequisites (class_id, prereq_class_id) values (125,112);

-- CIS 219 = (CIS 217)
insert into prerequisites (class_id, prereq_class_id) values (126,125);

-- CIS 221 = (CIS 102, CIS 111, CIS 115)
insert into prerequisites (class_id, prereq_class_id) values (127,98);
insert into prerequisites (class_id, prereq_class_id) values (127,102);
insert into prerequisites (class_id, prereq_class_id) values (127,105);

-- CIS 225 = (CIS 110)
insert into prerequisites (class_id, prereq_class_id) values (128,101);

-- CIS 229 = (CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (129,98);

-- CIS 254 = (CIS 102, CIS 106)
insert into prerequisites (class_id, prereq_class_id) values (130,98);
insert into prerequisites (class_id, prereq_class_id) values (130,100);

-- CIS 264 = (CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (131,98);

-- CIS 271 = (CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (132,98);

-- CIS 272 = (CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (133,98);

-- CIS 273 = (CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (134,98);

-- CIS 274 = (CIS 102)
insert into prerequisites (class_id, prereq_class_id) values (135,98);

-- CSI 131 = (MATH 203)
insert into prerequisites (class_id, prereq_class_id) values (136,293);

-- CSI 132 = (CSI 133)
insert into prerequisites (class_id, prereq_class_id) values (137,136);

-- CJ 101 = no prereqs
-- CJ 103 = no prereqs
-- CJ 104 = no prereqs
-- CJ 109 = (CJ 101)
insert into prerequisites (class_id, prereq_class_id) values (141,138);

-- CJ 111 = (CJ 101)
insert into prerequisites (class_id, prereq_class_id) values (142,138);

-- CJ 112 = no prereqs
-- CJ 201 = (CJ 101)
insert into prerequisites (class_id, prereq_class_id) values (144,138);

-- CJ 207 = (CJ 101)
insert into prerequisites (class_id, prereq_class_id) values (145,138);

-- CJ 213 = (SOC 101)
insert into prerequisites (class_id, prereq_class_id) values (146,367);

-- CJ 214 = (CJ 201)
insert into prerequisites (class_id, prereq_class_id) values (147,144);

-- CJ 215 = (CJ 201)
insert into prerequisites (class_id, prereq_class_id) values (148,144);

-- CJ 216 = (CJ 201)
insert into prerequisites (class_id, prereq_class_id) values (149,144);

-- CJ 283 = (CJ 201)
insert into prerequisites (class_id, prereq_class_id) values (150,144);

-- ECON 101 = no prereqs
-- ECON 102 = no prereqs
-- ECON 105 = no prereqs
-- ECON 106 = no prereqs
-- ECON 107 = no prereqs

-- EDUC 101 = no prereqs
-- EDUC 103 = no prereqs
-- EDUC 104 = no prereqs

-- EDUC 108 = (PSY 201)
insert into prerequisites (class_id, prereq_class_id) values (159,352);

-- EDUC 109 = no prereqs
-- EDUC 110 = no prereqs
-- EDUC 113 = no prereqs

-- EDUC 200 = (EDUC 101)
insert into prerequisites (class_id, prereq_class_id) values (163,156);

-- EDUC 201 = (EDUC 103, EDUC 104, EDUC 108)
insert into prerequisites (class_id, prereq_class_id) values (164,157);
insert into prerequisites (class_id, prereq_class_id) values (164,158);
insert into prerequisites (class_id, prereq_class_id) values (164,159);

-- EDUC 202 = (EDUC 200, EDUC 201)
insert into prerequisites (class_id, prereq_class_id) values (165,163);
insert into prerequisites (class_id, prereq_class_id) values (165,164);

-- EDUC 205 = (EDUC 101)
insert into prerequisites (class_id, prereq_class_id) values (166,156);

-- EDUC 206 = (EDUC 101)
insert into prerequisites (class_id, prereq_class_id) values (167,156);

-- EDUC 207 = (EDUC 101)
insert into prerequisites (class_id, prereq_class_id) values (168,156);

-- EDUC 208 = (EDUC 101)
insert into prerequisites (class_id, prereq_class_id) values (169,156);

-- EDUC 209 = (EDUC 206)
insert into prerequisites (class_id, prereq_class_id) values (170,167);

-- EDUC 210 = (EDUC 103)
insert into prerequisites (class_id, prereq_class_id) values (171,157);

-- EDUC 211 = (EDUC 101)
insert into prerequisites (class_id, prereq_class_id) values (172,156);

-- EDUC 212 = (EDUC 101)
insert into prerequisites (class_id, prereq_class_id) values (173,156);

-- EDUC 213 = (EDUC 101)
insert into prerequisites (class_id, prereq_class_id) values (174,156);

-- EDUC 214 = (EDUC 101)
insert into prerequisites (class_id, prereq_class_id) values (175,156);

-- EDUC 215 = (EDUC 103, EDUC 104)
insert into prerequisites (class_id, prereq_class_id) values (176,157);
insert into prerequisites (class_id, prereq_class_id) values (176,158);

-- EDUC 216 = (EDUC 103, EDUC 104)
insert into prerequisites (class_id, prereq_class_id) values (177,157);
insert into prerequisites (class_id, prereq_class_id) values (177,158);

-- EDUC 217 = (EDUC 101)
insert into prerequisites (class_id, prereq_class_id) values (178,156);

-- EDUC 218 = (EDUC 101)
insert into prerequisites (class_id, prereq_class_id) values (179,156);

-- EDUC 219 = (EDUC 103)
insert into prerequisites (class_id, prereq_class_id) values (180,157);

-- EDUC 220 = (EDUC 101)
insert into prerequisites (class_id, prereq_class_id) values (181,156);

-- EDUC 261 = (EDUC 101)
insert into prerequisites (class_id, prereq_class_id) values (182,156);

-- EDUC 262 = (EDUC 101)
insert into prerequisites (class_id, prereq_class_id) values (183,156);

-- EDUC 263 = (EDUC 101)
insert into prerequisites (class_id, prereq_class_id) values (184,156);

-- ENGR 101 = no prereqs
-- ENGR 103 = no prereqs
-- ENGR 104 = (ENGR 103, MATH 203)
insert into prerequisites (class_id, prereq_class_id) values (187,186);
insert into prerequisites (class_id, prereq_class_id) values (187,293);

-- ENGR 201 = (ENGR 104, PHYS 203)
insert into prerequisites (class_id, prereq_class_id) values (188,187);
insert into prerequisites (class_id, prereq_class_id) values (188,336);

-- ENGR 202 = (ENGR 104, MATH 204)
insert into prerequisites (class_id, prereq_class_id) values (189,187);
insert into prerequisites (class_id, prereq_class_id) values (189,294);

-- ENGR 203 = (ENGR 201)
insert into prerequisites (class_id, prereq_class_id) values (190,188);

-- ENGR 204 = (MATH 204, PHYS 204)
insert into prerequisites (class_id, prereq_class_id) values (191,294);
insert into prerequisites (class_id, prereq_class_id) values (191,337);

-- ENGR 206 = (ENGR 103, ENGR 204)
insert into prerequisites (class_id, prereq_class_id) values (192,186);
insert into prerequisites (class_id, prereq_class_id) values (192,191);

-- ENGR 207 = (MATH 204)
insert into prerequisites (class_id, prereq_class_id) values (193,294);

-- ENGR 210 = (MATH 208, ENGR 204, ENGR 206)
insert into prerequisites (class_id, prereq_class_id) values (194,296);
insert into prerequisites (class_id, prereq_class_id) values (194,191);
insert into prerequisites (class_id, prereq_class_id) values (194,192);

-- ENGR 232 = (CHEM 112, MATH 204, PHYS 203)
insert into prerequisites (class_id, prereq_class_id) values (195,85);
insert into prerequisites (class_id, prereq_class_id) values (195,294);
insert into prerequisites (class_id, prereq_class_id) values (195,336);

-- ENGR 273 = (ENGR 201)
insert into prerequisites (class_id, prereq_class_id) values (196,188);

-- ENG 001 = no prereqs
-- ENG 002 = no prereqs
-- ENG 003 = (ENG 002)
insert into prerequisites (class_id, prereq_class_id) values (199,198);

-- ENG 012 = (ENG 001)
insert into prerequisites (class_id, prereq_class_id) values (200,197);

-- ENG 017 = no prereqs
-- ENG 018 = no prereqs
-- ENG 059 = no prereqs
-- ENG 060 = (ENG 001)
insert into prerequisites (class_id, prereq_class_id) values (204,197);

-- ENG 081 = (ENG 001)
insert into prerequisites (class_id, prereq_class_id) values (205,197);

-- ENG 084 = no prereqs
-- ENG 101 = no prereqs
-- ENG 102 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (208,207);

-- ENG 107 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (209,207);

-- ENG 109 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (210,207);

-- ENG 110 = (ENG 107)
insert into prerequisites (class_id, prereq_class_id) values (211,209);

-- ENG 113 = (ENG 107)
insert into prerequisites (class_id, prereq_class_id) values (212,209);

-- ENG 193 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (213,207);

-- ENG 201 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (214,207);

-- ENG 202 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (215,207);

-- ENG 203 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (216,207);

-- ENG 204 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (217,207);

-- ENG 205 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (218,207);

-- ENG 206 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (219,207);

-- ENG 207 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (220,207);

-- ENG 208 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (221,207);

-- ENG 209 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (222,207);

-- ENG 210 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (223,207);

-- ENG 214 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (224,207);

-- ENG 215 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (225,207);

-- ENG 216 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (226,207);

-- ENG 217 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (227,207);

-- ENG 231 = (ENG 113)
insert into prerequisites (class_id, prereq_class_id) values (228,212);

-- ENG 232 = (ENG 231)
insert into prerequisites (class_id, prereq_class_id) values (229,228);

-- ENG 233 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (230,207);

-- ENG 234 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (231,207);

-- ENG 235 = (ENG 110)
insert into prerequisites (class_id, prereq_class_id) values (232,211);

-- ENG 236 = (ENG 235)
insert into prerequisites (class_id, prereq_class_id) values (233,232);

-- ENG 237 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (234,207);

-- ENG 238 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (235,207);

-- ENG 239 = (ENG 101)
insert into prerequisites (class_id, prereq_class_id) values (236,207);

-- HIST 101 = no prereqs
-- HIST 102 = (HIST 101)
insert into prerequisites (class_id, prereq_class_id) values (238,237);

-- HIST 103 = no prereqs
-- HIST 104 = (HIST 103)
insert into prerequisites (class_id, prereq_class_id) values (240,239);

-- HIST 109 = no prereqs
-- HIST 110 = (HIST 109)
insert into prerequisites (class_id, prereq_class_id) values (242,241);

-- HIST 112 = no prereqs
-- HIST 115 = no prereqs
-- HIST 201 = no prereqs
-- HIST 202 = no prereqs

-- HIST 203 = no prereqs
-- HIST 204 = no prereqs
-- HIST 207 = no prereqs
-- HIST 208 = no prereqs

-- HIST 210 = no prereqs
-- HIST 211 = no prereqs
-- HIST 214 = (ENG 101, HIST 101)
insert into prerequisites (class_id, prereq_class_id) values (253,207);
insert into prerequisites (class_id, prereq_class_id) values (253,237);

-- HIST 216 = (HIST 101)
insert into prerequisites (class_id, prereq_class_id) values (254,238);

-- HIST 217 = (ENG 101, HIST 102)
insert into prerequisites (class_id, prereq_class_id) values (255,207);
insert into prerequisites (class_id, prereq_class_id) values (255,238);

-- HIST 220 = no prereqs
-- HIST 263 = (HIST 101)
insert into prerequisites (class_id, prereq_class_id) values (257,237);

-- HIST 263A = no prereqs
-- HIST 263B = (HIST 101)
insert into prerequisites (class_id, prereq_class_id) values (259,237);

-- HIST 263C = no prereqs
-- HIST 283 = no prereqs

-- ISS 105 = no prereqs
-- ISS 111 = no prereqs
-- ISS 112 = (ISS 211)
insert into prerequisites (class_id, prereq_class_id) values (264,263);

-- ISS 213 = (ISS 112)
insert into prerequisites (class_id, prereq_class_id) values (265,264);

-- ISS 214 = (ISS 213)
insert into prerequisites (class_id, prereq_class_id) values (266,265);

-- ISS 220 = (CIS 210)
insert into prerequisites (class_id, prereq_class_id) values (267,121);

-- ISS 221 = (ISS 220)
insert into prerequisites (class_id, prereq_class_id) values (268,267);

-- ISS 222 = (CIS 210, ISS 112)
insert into prerequisites (class_id, prereq_class_id) values (269,121);
insert into prerequisites (class_id, prereq_class_id) values (269,264);

-- MATH 001 = no prereqs
-- MATH 002 = (MATH 001)
insert into prerequisites (class_id, prereq_class_id) values (271,270);

-- MATH 010 = no prereqs
-- MATH 014 = no prereqs
-- MATH 017 = (MATH 002)
insert into prerequisites (class_id, prereq_class_id) values (274,271);

-- MATH 018 = (MATH 010)
insert into prerequisites (class_id, prereq_class_id) values (275,272);

-- MATH 019 = no prereqs
-- MATH 020 = no prereqs
-- MATH 021 = (MATH 020)
insert into prerequisites (class_id, prereq_class_id) values (278,277);

-- MATH 022 = (MATH 021)
insert into prerequisites (class_id, prereq_class_id) values (279,278);

-- MATH 023 = (MATH 022)
insert into prerequisites (class_id, prereq_class_id) values (280,279);

-- MATH 024 = (MATH 021)
insert into prerequisites (class_id, prereq_class_id) values (281,278);

-- MATH 025 = (MATH 024)
insert into prerequisites (class_id, prereq_class_id) values (282,281);

-- MATH 026 = (MATH 025)
insert into prerequisites (class_id, prereq_class_id) values (283,282);

-- MATH 027 = (MATH 021)
insert into prerequisites (class_id, prereq_class_id) values (284,278);

-- MATH 081 = no prereqs
-- MATH 082 = no prereqs
-- MATH 101 = no prereqs
-- MATH 102 = no prereqs
-- MATH 103 = no prereqs
-- MATH 109 = no prereqs
-- MATH 111 = no prereqs
-- MATH 131 = no prereqs
-- MATH 203 = no prereqs
-- MATH 204 = (MATH 203)
insert into prerequisites (class_id, prereq_class_id) values (294,293);

-- MATH 206 = (MATH 204)
insert into prerequisites (class_id, prereq_class_id) values (295,294);

-- MATH 208 = (MATH 204)
insert into prerequisites (class_id, prereq_class_id) values (296,294);

-- MATH 210 = (MATH 203)
insert into prerequisites (class_id, prereq_class_id) values (297,293);

-- MATH 211 = no prereqs
-- MATH 212 = no prereqs
-- MATH 216 = no prereqs
-- MATH 217 = (MATH 203)
insert into prerequisites (class_id, prereq_class_id) values (301,293);

-- PHIL 101 = no prereqs
-- PHIL 200 = no prereqs
-- PHIL 205 = no prereqs
-- PHIL 220 = no prereqs

-- PHIL 221 = no prereqs
-- PHIL 222 = no prereqs
-- PHIL 250 = no prereqs

-- PE 101 = no prereqs
-- PE 102 = no prereqs
-- PE 104 = no prereqs
-- PE 130 = no prereqs
-- PE 131 = no prereqs

-- PE 133 = no prereqs
-- PE 134 = no prereqs
-- PE 135 = no prereqs
-- PE 136 = no prereqs

-- PE 137 = no prereqs
-- PE 138 = no prereqs
-- PE 147 = no prereqs
-- PE 150 = no prereqs

-- PE 153 = no prereqs
-- PE 154 = no prereqs
-- PE 155 = no prereqs
-- PE 169 = no prereqs

-- PE 171 = no prereqs
-- PE 178 = no prereqs
-- PE 191 = no prereqs
-- PE 228 = no prereqs
-- PE 229 = no prereqs

-- PE 230 = no prereqs
-- PE 273 = no prereqs

-- PHYS 101 = no prereqs 
-- PHYS 102 = (PHYS 101)
insert into prerequisites (class_id, prereq_class_id) values (334,333);

-- PHYS 200 = (PHYS 203)
insert into prerequisites (class_id, prereq_class_id) values (335,336);

-- PHYS 203 = (MATH 203)
insert into prerequisites (class_id, prereq_class_id) values (336,293);

-- PHYS 204 = (PHYS 203, MATH 204)
insert into prerequisites (class_id, prereq_class_id) values (337,336);
insert into prerequisites (class_id, prereq_class_id) values (337,294);

-- PHYS 205 = (PHYS 204)
insert into prerequisites (class_id, prereq_class_id) values (338,337);

-- PS 101 = no prereqs
-- PS 102 = no prereqs
-- PS 106 = no prereqs
-- PS 201 = no prereqs

-- PS 203 = no prereqs
-- PS 204 = no prereqs
-- PS 263 = no prereqs
-- PS 281 = no prereqs

-- PS 282 = no prereqs
-- PS 283 = no prereqs
-- PS 284 = no prereqs
-- PS 285 = no prereqs
-- PS 286 = no prereqs

-- PSY 101 = no prereqs
-- PSY 105 = no prereqs
-- PSY 202 = (PSY 101)
insert into prerequisites (class_id, prereq_class_id) values (354,352);

-- PSY 204 = (PSY 101)
insert into prerequisites (class_id, prereq_class_id) values (355,352);

-- PSY 205 = (PSY 101)
insert into prerequisites (class_id, prereq_class_id) values (356,352);

-- PSY 207 = (PSY 101)
insert into prerequisites (class_id, prereq_class_id) values (357,352);

-- PSY 208 = (PSY 101)
insert into prerequisites (class_id, prereq_class_id) values (358,352);

-- PSY 209 = (PSY 101)
insert into prerequisites (class_id, prereq_class_id) values (359,352);

-- PSY 210 = (PSY 101)
insert into prerequisites (class_id, prereq_class_id) values (360,352);

-- PSY 212 = (PSY 101)
insert into prerequisites (class_id, prereq_class_id) values (361,352);

-- PSY 214 = (PSY 101)
insert into prerequisites (class_id, prereq_class_id) values (362,352);

-- PSY 216 = (PSY 101)
insert into prerequisites (class_id, prereq_class_id) values (363,352);

-- PSY 263 = (PSY 101)
insert into prerequisites (class_id, prereq_class_id) values (364,352);

-- PSY 273 = (PSY 101)
insert into prerequisites (class_id, prereq_class_id) values (365,352);

-- PSY 274 = (PSY 273)
insert into prerequisites (class_id, prereq_class_id) values (366,365);

-- SOC 101 = no prereqs
-- SOC 102 = no prereqs
-- SOC 200 = (SOC 101)
insert into prerequisites (class_id, prereq_class_id) values (369,367);

-- SOC 201 = (SOC 101)
insert into prerequisites (class_id, prereq_class_id) values (370,367);

-- SOC 213 = (SOC 101)
insert into prerequisites (class_id, prereq_class_id) values (371,367);

-- SOC 214 = (SOC 101)
insert into prerequisites (class_id, prereq_class_id) values (372,367);

-- SOC 263 = (SOC 101)
insert into prerequisites (class_id, prereq_class_id) values (373,367);

-- SOC 273 = (SOC 101)
insert into prerequisites (class_id, prereq_class_id) values (374,367);