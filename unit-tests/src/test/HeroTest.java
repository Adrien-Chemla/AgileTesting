package test;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import codingfactory.rpgconsole.hero.Hero;
import codingfactory.rpgconsole.enemy.Enemy;

public class HeroTest {

	/*@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Avant le démarrage");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Après tous les tests");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Avant un test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Après un test");
	} */	
	
	@Test
	public void testHeroSetLevel(){
		Hero hero = new Hero("Jaina Portvaillant");

		hero.setLevel(10);
		assertThat(hero.getLevel(), is(10));

	}

	@Test
	public void testHeroLevelUp() throws Exception {
		Hero hero = new Hero("Jaina Portvaillant");

		int level = hero.getLevel();
		hero.levelUp();
		assertThat(hero.getLevel(), greaterThan(level));
	}

	@Test
	public void testHeroTakeDamage(){
		Hero hero = new Hero("Jaina Portvaillant");

		int hp = hero.getHp();
		hero.takeDamage(10);
		assertThat(hero.getHp(),lessThan(hp));
	}
	
	@Test
    public void testHeroGetAttack() throws Exception {
        Hero hero = new Hero("Jaina Portvaillant");
        assertThat(hero.getAttack(), greaterThanOrEqualTo(2));
    }

	@Test
	public void testHeroAttack() throws Exception {
		Hero hero = new Hero("Jaina Portvaillant");
		Enemy enemy = new Enemy("Skeleton", 1);

		int hp = enemy.getHp();
		hero.attack(enemy);
		assertThat(enemy.getHp(), lessThan(hp));

	}
	
	@Test    
    public void testHeroGetHp() throws Exception {
        Hero hero = new Hero("Jaina Portvaillant");
        assertThat(hero.getHp(), greaterThanOrEqualTo(20));
    }

	@Test
	public void testHeroProperties() throws Exception {
		Hero hero = new Hero("Jaina Portvaillant");
		
		assertThat(hero, hasProperty("name"));
       	assertThat(hero, hasProperty("name", is("Jaina Portvaillant")));
        assertThat(hero, hasProperty("hp"));
        assertThat(hero, hasProperty("hp", is(20)));
        assertThat(hero, hasProperty("level"));
        assertThat(hero, hasProperty("level", is(1)));
	}

}
