keystores och truststores f�r anv�ndare sparas som ks_anv�ndare respektive ts_anv�ndare
Ex: Anv�ndare doktor1 har en truststore och en keystore som heter ks_doktor1 / ts_doktor1
Vid login i GUIclient anv�nds anv�ndarnamnet och l�senordet till keystoren ex: U: doktor1 P: md1pass
Client kopplar d� en ssl kommunikation med server, f�rutsatt att server k�rs. Detta k�rs med doktor1's keystores

Ej implementerat:
varningmeddelande om anv�ndare eller l�senord �r fel

Planerad implementering:

Records:
server h�mtar CN fr�n anv�ndarens keystore ex. doktor1
Hittar alla records som �r kopplade till doktor1
Skickar tillbaka records (records borde h�lla koll p� sina egna r�ttigheter ocks�)
ClientGUI visar records med r�tt beh�righeter
ClientGUI skickar genom Client tillbaka �ndrade records, nya records eller kommando om borttagna records.
Servern sparar �ndringar.

Logga ut funktion
Avsluta funktion

Nya stores:
ts_doktor1, Alias: doktor1, l�senord: md1pass
ks_doktor1, Alias: doktor1, l�senord: md1pass
servertruststore2, Alias:server, l�senord: password
serverkeystore2, Alias: server, l�senord: password
