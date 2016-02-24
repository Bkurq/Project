keystores och truststores för användare sparas som ks_användare respektive ts_användare
Ex: Användare doktor1 har en truststore och en keystore som heter ks_doktor1 / ts_doktor1
Vid login i GUIclient används användarnamnet och lösenordet till keystoren ex: U: doktor1 P: md1pass
Client kopplar då en ssl kommunikation med server, förutsatt att server körs. Detta körs med doktor1's keystores

Ej implementerat:
varningmeddelande om användare eller lösenord är fel

Planerad implementering:

Records:
server hämtar CN från användarens keystore ex. doktor1
Hittar alla records som är kopplade till doktor1
Skickar tillbaka records (records borde hålla koll på sina egna rättigheter också)
ClientGUI visar records med rätt behörigheter
ClientGUI skickar genom Client tillbaka ändrade records, nya records eller kommando om borttagna records.
Servern sparar ändringar.

Logga ut funktion
Avsluta funktion

Nya stores:
ts_doktor1, Alias: doktor1, lösenord: md1pass
ks_doktor1, Alias: doktor1, lösenord: md1pass
servertruststore2, Alias:server, lösenord: password
serverkeystore2, Alias: server, lösenord: password
