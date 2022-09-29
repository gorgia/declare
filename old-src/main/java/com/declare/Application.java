package com.declare;

import com.declare.declaration.BridgeHandDescription;
import com.declare.table.Directions;
import com.declare.table.Player;
import com.declare.table.Seat;
import com.declare.table.Table;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

	public void createTable() {
		int numberOfPlayers = 4;
		Player player1 = new Player("Topolino");
		Player player2 = new Player("Paperino");
		Player player3 = new Player("Minnie");
		Player player4 = new Player("Paperina");

		Table table = new Table(numberOfPlayers);
		table.occupyEmptySeat(player1);
		table.occupyEmptySeat(player2);
		table.occupyEmptySeat(player3);
		table.occupyEmptySeat(player4);
		BridgeHandDescription bhdCheater = new BridgeHandDescription();
		bhdCheater.totalPoints = 30F;
		ArrayList<Seat> cheatersSeats = new ArrayList<Seat>();
		cheatersSeats.add(table.getSeat(Directions.SUD));
		table.getDealer().doCheat(cheatersSeats, bhdCheater);
		//table.getDealer().distributeAllCardsToSeats(table.getSeats());
		table.startRound();
		Seat seat = table.getSeat(Directions.SUD);
		System.out.println(table.getSeat(Directions.SUD).getPlayer().getHand().getCards());
	}

	public static void launchBrowser(String address) {
		// Start browser
		if (Desktop.isDesktopSupported()) {
			Desktop dt = Desktop.getDesktop();
			if (dt.isSupported(Desktop.Action.BROWSE)) {
				try {
					//File f = new File(filePath);
					URI uri = new URI(address);
					dt.browse(uri);
				} catch (URISyntaxException | IOException ex) {
					log.error("", ex);
				}
			}
		}
	}
}
