# KSwe SoSe 2017 - Übung zu Test-Driven Development

In dieser Aufgabe soll an einigen Beispielen das Konzept des Test-Driven
Development (TDD) umgesetzt werden.

## Teil 1: TimeSeriesTest

Der Unit-Test `TimeSeriesTest` enthält eine Test-Method `public void testStatistics()`.
Gehe nach dem TDD-Verfahren vor und realisiere die entsprechende Logik, die im
Test definiert ist. Es müssen die Klassen `TimeSeries` und
`Observation` sowie deren Logik erstellt werden.

## Teil 2: Erweiterung des TimeSeriesTest mit Maßeinheiten

Erweitere den  Unit-Test `TimeSeriesTest` so, dass die Klassen `TimeSeries` und
`Observation` wie folgt erweitert werden:

* für eine `Observation` soll eine Maßeinheit definiert werden können (z.B. im
  Constructor)
 * folgende Einheiten sollen unterstützt werden: `m`, `dm`, `cm`, `mm`
* die Klasse `TimeSeries` soll um die Möglichkeit erweitert werden, den Mittelwert
  in einer bestimmten Maßeinheit ausgeben zu können

Auch hier soll nach TDD vorgegangen werden. Schreibe eine zusätzliche Methode,
die mit `@Test` annotiert ist und entsprechend als Test ausgeführt wird.

## Teil 3: Neue Funktionalität für die Klasse `Station`

Die Klasse `Station` repräsentiert eine Messstation. Diese soll um zwei
Funktionen erweitert werden:

1. Berechnung der Entfernung zu einer anderen Station
2. Assoziation mit mehreren Zeitreihen

Für den ersten Teil soll der `Point` im Feld `location` als Berechnungsgrundlage
genutzt werden.

Der zweite Teil soll eine Methode zum Hinzufügen einer Zeitreihe
(`void addTimeSeries(TimeSeries ts)`) und zum Ausgeben der assozierten Zeitreihen
(`List<TimeSeries> getTimeSeries()`) entwickelt werden.

Es soll nach TDD vorgegangen werden. Schreibe eine eigene Klasse (mit
entsprechenden Test-Methoden) für den Test.

### Tipp

Die Klasse `Station` nutzt die JTS-Bibliothek zur Speicherung des `Point`. Ein
`Point`-Objekt kann wie folgt erstellt werden:

```java
GeometryFactory gf = new GeometryFactory();
Point point = gf.createPoint(new Coordinate(12.0, 20.0));
```

## Teil 4: Verarbeitung von Bestellungen

In diesem Teil soll die Logik der Klasse `OrderManager` realisiert werden.
Es soll ein Test (--> `OrderManagerTest`) entwickelt werden, der folgende
Funktionalität der Klasse sicherstellt:

1. über eine Methode (z.B. `public void submitOrder(Order o)`) sollen neue
Bestellungen in den Manager aufgenommen werden
1. eine Methode (z.B. `List<Order> getQueuedOrders()`) soll die eingestellten
(und noch nicht ausgeliefert) Bestellungen zurückgeben
1. die Auslieferung der Bestellungen soll über eine Methode `void processOrders()`
angestoßen werden und die Methode `void deliver(Product p, Customer c)` der
Klasse `ProductDeliveryService` anstoßen
1. nach Ausführung von `processOrders()` soll die Liste der noch nicht ausgelieferten
Bestellungen wieder leer sein
1. die Auslieferung der Bestellungen soll priorisiert durchgeführt werden (siehe
  Methode `Order#getPriority()`)

*Anmerkung: genau genommen wird hier kein Unit-Test mehr entwickelt, sondern ein
Integrations-Test, da bestimmte Abläufe über ggf. mehrere Klassen getestet werden.*

## Veröffentlichung

Committe und Pushe Deine Ergebnisse in deinen GitHub-Fork
