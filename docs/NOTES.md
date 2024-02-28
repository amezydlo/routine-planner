## TODO

Chyba trzeba będzie jednak przemyśleć kwestię kont użytkowników wcześniej...
Obecnie założenie jest takie, że jest to aplikacja tylko dla 1 osoby (bez sensu xd).

Np. każdy widzi wszystkie tagi, routyny itp...









```java
public class TeamUsers {

    @EmbeddedId
    private TeamUserId id;

    @ManyToOne
    @MapsId("teamId")
    @JoinColumn(name = "team_id")
    @JsonIgnoreProperties("team_users")
    private Team team;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("team_users")
    private User user;

    @Column(name = "active")
    private int active;
}
```
