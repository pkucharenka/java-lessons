package ru.minesweeperLesson.minesweeper.gui;

import ru.minesweeperLesson.minesweeper.BaseAction;
import ru.minesweeperLesson.minesweeper.interfaces.IGeneratorBoard;
import ru.minesweeperLesson.minesweeper.interfaces.ILogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUIAction extends BaseAction implements ActionListener, MouseListener {

	private GUIBoard board;

	public GUIAction(ILogic logic, GUIBoard board, IGeneratorBoard generator) {
		super(logic, board, generator);
		this.board = board;
		this.board.addMouseListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		this.initGame();
	}

	public void mouseClicked(MouseEvent e) {
		board.repaint();
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}