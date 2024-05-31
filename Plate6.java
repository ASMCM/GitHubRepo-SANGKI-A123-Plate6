import javax.swing.*;

public class Plate6 {
	public static void main(String[] args) {
		String menu_Sangki[] = {"Program 1", "Exit"};
		String option_Sangki;
		
		do {
			option_Sangki = (String) 
			JOptionPane.showInputDialog(
			null, 
			"Please select",
			"Plate #6", 
			1, 
			null, 
			menu_Sangki, 
			menu_Sangki[0]);
			
			switch (option_Sangki) {
				case "Program 1":
					int vertices_Sangki = Integer.parseInt(
						JOptionPane.showInputDialog(
						null, 
						"Enter the number of vertices: ")
						);
					
					Graph graph_Sangki = new Graph();
					for (int i = 0; i < vertices_Sangki; i++) {
						graph_Sangki.addVertex(i);
					}
					
					int edges_Sangki = Integer.parseInt(
						JOptionPane.showInputDialog(
						null, 
						"Enter the number of edges: ")
						);
					
					for (int i = 0; i < edges_Sangki; i++) {
						int source_Sangki = Integer.parseInt(
							JOptionPane.showInputDialog(
							null, 
							"Enter the source "+(i+1)+": ")
							);
						int destination_Sangki = Integer.parseInt(
							JOptionPane.showInputDialog(
							null, 
							"Enter the destination "+(i+1)+": ")
							);
						graph_Sangki.addEdge(source_Sangki, destination_Sangki);
					}
					
					String result_Sangki = "Is the graph connected? "
					+graph_Sangki.isConnectedFromVertex(0)+
					"\nNumber of connected components: "
					+graph_Sangki.numberOfConnectedComponents();
					JOptionPane.showMessageDialog(null, new JTextArea(result_Sangki));
					break;
				default:
					JOptionPane.showMessageDialog(
					null, 
					"Program terminated.");
                    break;
			}
		} while (!option_Sangki.equalsIgnoreCase("Exit"));
	}
}