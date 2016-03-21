keystores och truststores f�r anv�ndare sparas som ks_anv�ndare respektive ts_anv�ndare
Ex: Anv�ndare doktor1 har en truststore och en keystore som heter ks_doktor1 / ts_doktor1
Vid login i GUIclient anv�nds anv�ndarnamnet och l�senordet till keystoren ex: U: doktor1 P: md1pass
Client kopplar d� en ssl kommunikation med server, f�rutsatt att server k�rs. Detta k�rs med doktor1's keystores

Server:
servertruststore2, Alias:server, l�senord: password
serverkeystore2, Alias: server, l�senord: password

Anv�ndare:

Doktor 1, anv�ndarnamn: doctor1, l�senord: md1pass, CN: doctor1 DOCTOR diagnostik
Doktor 2, anv�ndarnamn: doctor2, l�senord: md2pass, CN: doctor2 DOCTOR medicin
Nurse 1, anv�ndarnamn: nurse1, l�senord: nu1pass, CN: nurse1 NURSE medicin
Nurse 2, anv�ndarnamn: nurse2, l�senord: nu2pass, CN: nurse2 NURSE diagnostik
Patient 1, anv�ndarnamn: patient1, l�senord: pa1pass, CN: patient1 PATIENT medicin
Patient 2, anv�ndarnamn: patient2, l�senord: pa2pass, CN: patient2 PATIENT diagnostik
Gov Agency, anv�ndarnamn: govagency, l�senord: gopass, CN: gov GOV 

Servern ska ha porten som argument. log.txt och mappen records måste i samma map som servern. 
I mappen records får bara giltiga record filer finnnas.

