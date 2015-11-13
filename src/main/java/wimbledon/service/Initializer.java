package wimbledon.service;

import javax.annotation.PostConstruct;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import wimbledon.entity.Court;
import wimbledon.entity.Gender;
import wimbledon.entity.Round;
import wimbledon.entity.Umpire;
import wimbledon.entity.draw.doubles.MensDoublesDraw;
import wimbledon.entity.draw.doubles.MixedDoublesDraw;
import wimbledon.entity.draw.doubles.WomensDoublesDraw;
import wimbledon.entity.draw.singles.MensSingleDraw;
import wimbledon.entity.draw.singles.WomensSingleDraw;
import wimbledon.entity.match.Match;
import wimbledon.entity.match.SinglesMatch;
import wimbledon.entity.player.Player;
import wimbledon.entity.team.MensDoublesTeam;
import wimbledon.entity.team.MixedDoublesTeam;
import wimbledon.entity.team.WomensDoublesTeam;

/**
 *
 * @author vrg
 */
@Singleton
@Startup
public class Initializer {
    @EJB
    private Initializer proxy;
    @PersistenceContext
    private EntityManager em;
    
    @PostConstruct
    private void init() {
        proxy.initAsync();
    }
    
    @Asynchronous
    public void initAsync() {
        Player alex = Player.builder().name("Nagy Alex").gender(Gender.MALE).build();
        Player bela = Player.builder().name("Kovacs Bela").gender(Gender.MALE).build();
        Player csaba = Player.builder().name("Bimbo Csaba").gender(Gender.MALE).build();
        Player jozsef = Player.builder().name("Nagy Jozsef").gender(Gender.MALE).build();
        Player aliz = Player.builder().name("Feher Aliz").gender(Gender.FEMALE).build();
        Player bea = Player.builder().name("Voros Bea").gender(Gender.FEMALE).build();
        Player timea = Player.builder().name("Vastag Timea").gender(Gender.FEMALE).build();
        Player ildiko = Player.builder().name("Horvath Ildiko").gender(Gender.FEMALE).build();
        
        Umpire biroJanos = new Umpire("Biro Janos");
        Umpire biroFerenc = new Umpire("Biro Ferenc");
        
        Court pirosPalya = new Court("piros");
        Court kekPalya = new Court("kek");
        Court sargaPalya = new Court("sarga");
        Court zoldPalya = new Court("zold");
        
        MensDoublesTeam mdt1 = new MensDoublesTeam(alex, bela);
        MensDoublesTeam mdt2 = new MensDoublesTeam(csaba, jozsef);
        WomensDoublesTeam wdt1 = new WomensDoublesTeam(aliz, bea);
        WomensDoublesTeam wdt2 = new WomensDoublesTeam(timea, ildiko);
        MixedDoublesTeam mxdt1 = new MixedDoublesTeam(aliz, alex);
        MixedDoublesTeam mxdt2 = new MixedDoublesTeam(bea, bela);
        
        MensDoublesDraw mdDraw = new MensDoublesDraw();
        mdDraw.register(mdt1).register(mdt2)
                .addCourt(kekPalya).addCourt(pirosPalya)
                .addUpire(biroFerenc);
        WomensDoublesDraw wdDraw = new WomensDoublesDraw();
        wdDraw.register(wdt1).register(wdt2)
                .addCourt(kekPalya).addCourt(pirosPalya)
                .addUpire(biroFerenc);
        MixedDoublesDraw mxdDraw = new MixedDoublesDraw();
        mxdDraw.register(mxdt1).register(mxdt2)
                .addCourt(kekPalya).addCourt(pirosPalya)
                .addUpire(biroFerenc);
        
        MensSingleDraw msDraw =  new MensSingleDraw();
        msDraw.register(alex).register(bela).register(csaba).register(jozsef)
                .addCourt(kekPalya).addCourt(zoldPalya)
                .addUpire(biroJanos);
        
        WomensSingleDraw wsDraw = new WomensSingleDraw();
        wsDraw.register(aliz).register(timea).register(bea).register(ildiko)
                .addCourt(kekPalya).addCourt(sargaPalya)
                .addUpire(biroJanos);
        
        wsDraw.replaceRound(new Round(1)).replaceRound(new Round(2));
        wsDraw.getRound(1)
                .addMatch(new SinglesMatch(aliz, bea))
                .addMatch(new SinglesMatch(timea, ildiko));
        wsDraw.getRound(2)
                .addMatch(new SinglesMatch(aliz,ildiko));
                
        em.persist(mdDraw);
        em.persist(wdDraw);
        em.persist(mxdDraw);
        em.persist(msDraw);
        em.persist(wsDraw);
        
    }
    
}
