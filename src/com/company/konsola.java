package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;

public class konsola {


	public static void main(String[] args) {

		JFrame frame = new JFrame("Problem plecakowy");
		frame.setSize(400,500);

		JTextArea wpiszPojemnosc= new JTextArea();
		JTextArea miejsce_na_liczbe = new JTextArea(1,16);
		JTextArea textArea = new JTextArea(16,30);
		textArea.setEditable(false);
		wpiszPojemnosc.setEditable(false);

		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


		JButton b=new JButton("Oblicz");
		JButton change_color_button = new JButton("Change color");


		JPanel panel = new JPanel();
		panel.add(wpiszPojemnosc);
		panel.add(miejsce_na_liczbe);
		wpiszPojemnosc.append("Wpisz pojemnosc:");
		//panel.add(textArea);
		panel.add(scroll);
		panel.add(b);
		panel.add(change_color_button);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.setVisible(true);
		Color color_list[] = {Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA, Color.GRAY, Color.PINK, Color.ORANGE, Color.YELLOW};

		change_color_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				panel.setBackground(Color.RED);
				Random r=new Random();
				int randomNumber=r.nextInt(color_list.length);
				panel.setBackground((Color)Array.get(color_list, randomNumber));
			}});


		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//int capacity = Integer.parseInt(wpiszPojemnosc.getText().split(":")[1]);
				int capacity = Integer.parseInt(miejsce_na_liczbe.getText());

				int n,sumWeight=0, sumValue=0, loop=0;

				n = (int)(Math.random()*(15-5+1)+5);
				textArea.append("ilosc przedmiotow "+n+"  "+"pojemnosc "+capacity+"\n");
				System.out.print("ilosc przedmiotow "+n+"  "+"pojemnosc "+capacity+"\n");

				Item items[] = new Item[n];

				for(int i=0; i<n; i++) {
					items[i] = new Item((int)(Math.random()*(20-10+1)+10), (int)(Math.random()*(20-10+1)+10));
					textArea.append("przedmiot "+i+" waga"+items[i].weight+"  "+"wartosc "+items[i].value+"\n");
					System.out.print("przedmiot "+i+" waga"+items[i].weight+"  "+"wartosc "+items[i].value+"\n");
				}

				for(int i=0; i<n; i++) {
					if(sumWeight+items[i].weight < capacity) {
						loop++;
						sumWeight += items[i].weight;
						sumValue  += items[i].value;
					}else break;
				}
				textArea.append("suma wagi "+sumWeight+" suma wartosci "+sumValue+"\n");
				textArea.append("wlozone przedmioty\n");
				System.out.print("suma wagi "+sumWeight+" suma wartosci "+sumValue+"\n");
				System.out.print("wlozone przedmioty\n");


				for(int i=0; i<loop; i++) {
					textArea.append("przedmiot "+i+" waga"+items[i].weight+"  "+"wartosc "+items[i].value+"\n");
					System.out.print("przedmiot "+i+" waga"+items[i].weight+"  "+"wartosc "+items[i].value+"\n");
				}
			}
		});





	}
}
