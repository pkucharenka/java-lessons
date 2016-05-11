package ru.poker;

import ru.poker.Classes.Cart;
import ru.poker.Classes.Gamer;
import ru.poker.Classes.Table;
import ru.poker.Interfaces.IGenerator;
import ru.poker.Interfaces.Progress;

public class BaseAction implements Progress {

	private final IGenerator generator;
	private final Table table;

	public BaseAction(final Table table, final IGenerator generator) {
		this.generator = generator;
		this.table = table;
	}

	@Override
	public void initGame() {
		final Cart[] deck = generator.generateDeck();
        this.table.loadDeck(deck);
        final Gamer[] gamers = generator.generateGamers();
        this.table.loadGamers(gamers);
        this.table.writingDeck();
//		this.table.drawGamers();
	}

    @Override
    public void progress() {
//        System.out.println("============== КОЛОДА КАРТ ==============");
//        this.table.drawDeck();
        this.table.randomCart();
        System.out.println("============== ВСЕ ИГРОКИ ==============");
        this.table.drawGamers();
    }
}