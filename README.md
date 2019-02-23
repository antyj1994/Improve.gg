# Improvegg

### 1. Panoramica
  Improve.gg e' un progetto web nato con lo scopo di fornire statistiche ed informazioni aggiuntive sugli accounts degli utenti di League     of Legends.
  In particolare, tramite questa piattaforma e' possibile cercare specifici accounts in tutto il mondo e visualizzare un resoconto delle
  loro ultime partite.
  Il sistema ottiene dati grezzi tramite le API della Riot Games, elabora queste informazioni e restituisce un resoconto del match, 
  segnalando cosa e' stato fatto al meglio e cosa no, e fornendo dati utili agli utenti su come poter migliorare le proprie prestazioni.

### 2. Architettura
  Il sito e' stato interamente sviluppato seguendo il pattern MVC. Per quanto riguarda la persistenza dei dati e' stato utilizzato un      
  database remoto che salva periodicamente le partite dei giocatori piu' famosi e, tramite richiesta, quelle di tutti gli accounts
  cercati dagli utenti, esso comunica tramite tecnologia JDBC.
  La parte Front-End utilizza il framework Bootstrap e le pagine dinamiche sono generate da file JSP, il sistema inoltre supporta la
  tecnologia AJAX per il caricamento asincrono di dati aggiuntivi.
  
## Aggiornamento Feb 2019
Il sistema di recupero dei dati dalle API Riot non e' piu in funzione in quanto la Riot stessa ha lanciato un nuovo sistema di API completamente nuovo ed incompatibile con quello vecchio. Il progetto Improve.gg attualmente e' in pausa fino a data da destinarsi.

