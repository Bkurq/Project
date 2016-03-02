keystores och truststores för användare sparas som ks_användare respektive ts_användare
Ex: Användare doktor1 har en truststore och en keystore som heter ks_doktor1 / ts_doktor1
Vid login i GUIclient används användarnamnet och lösenordet till keystoren ex: U: doktor1 P: md1pass
Client kopplar då en ssl kommunikation med server, förutsatt att server körs. Detta körs med doktor1's keystores

Server:
servertruststore2, Alias:server, lösenord: password
serverkeystore2, Alias: server, lösenord: password

Användare:

Doktor 1, användarnamn: doctor1, lösenord: md1pass, CN: doctor1 DOCTOR diagnostik
Doktor 2, användarnamn: doctor2, lösenord: md2pass, CN: doctor2 DOCTOR medicin
Nurse 1, användarnamn: nurse1, lösenord: nu1pass, CN: nurse1 NURSE medicin
Nurse 2, användarnamn: nurse2, lösenord: nu2pass, CN: nurse2 NURSE diagnostik
Patient 1, användarnamn: patient1, lösenord: pa1pass, CN: patient1 PATIENT medicin
Patient 2, användarnamn: patient2, lösenord: pa2pass, CN: patient2 PATIENT diagnostik
Gov Agency, användarnamn: govagency, lösenord: gopass, CN: gov GOV 



