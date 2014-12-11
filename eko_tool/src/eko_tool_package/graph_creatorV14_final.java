package eko_tool_package;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.apache.commons.collections15.Transformer;
import org.apache.commons.collections15.functors.ConstantTransformer;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLAsymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataAllValuesFrom;
import org.semanticweb.owlapi.model.OWLDataComplementOf;
import org.semanticweb.owlapi.model.OWLDataExactCardinality;
import org.semanticweb.owlapi.model.OWLDataHasValue;
import org.semanticweb.owlapi.model.OWLDataIntersectionOf;
import org.semanticweb.owlapi.model.OWLDataMaxCardinality;
import org.semanticweb.owlapi.model.OWLDataMinCardinality;
import org.semanticweb.owlapi.model.OWLDataOneOf;
import org.semanticweb.owlapi.model.OWLDataPropertyCharacteristicAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLDataPropertyExpression;
import org.semanticweb.owlapi.model.OWLDataPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLDataRange;
import org.semanticweb.owlapi.model.OWLDataSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLDataUnionOf;
import org.semanticweb.owlapi.model.OWLDatatypeDefinitionAxiom;
import org.semanticweb.owlapi.model.OWLDifferentIndividualsAxiom;
import org.semanticweb.owlapi.model.OWLDisjointClassesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLDisjointUnionAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentClassesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentDataPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLEquivalentObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalDataPropertyAxiom;
import org.semanticweb.owlapi.model.OWLFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLHasKeyAxiom;
import org.semanticweb.owlapi.model.OWLInverseFunctionalObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLInverseObjectPropertiesAxiom;
import org.semanticweb.owlapi.model.OWLIrreflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLObjectAllValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectComplementOf;
import org.semanticweb.owlapi.model.OWLObjectExactCardinality;
import org.semanticweb.owlapi.model.OWLObjectHasSelf;
import org.semanticweb.owlapi.model.OWLObjectHasValue;
import org.semanticweb.owlapi.model.OWLObjectIntersectionOf;
import org.semanticweb.owlapi.model.OWLObjectMaxCardinality;
import org.semanticweb.owlapi.model.OWLObjectMinCardinality;
import org.semanticweb.owlapi.model.OWLObjectOneOf;
import org.semanticweb.owlapi.model.OWLObjectPropertyCharacteristicAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyDomainAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLObjectPropertyRangeAxiom;
import org.semanticweb.owlapi.model.OWLObjectSomeValuesFrom;
import org.semanticweb.owlapi.model.OWLObjectUnionOf;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLReflexiveObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLSameIndividualAxiom;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.OWLSubDataPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubObjectPropertyOfAxiom;
import org.semanticweb.owlapi.model.OWLSubPropertyChainOfAxiom;
import org.semanticweb.owlapi.model.OWLSymmetricObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLTransitiveObjectPropertyAxiom;



import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.GridLayout;



import edu.uci.ics.jung.algorithms.layout.AggregateLayout;
import edu.uci.ics.jung.algorithms.layout.DAGLayout;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.FRLayout2;
import edu.uci.ics.jung.algorithms.layout.ISOMLayout;
import edu.uci.ics.jung.algorithms.layout.KKLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.LayoutDecorator;
import edu.uci.ics.jung.algorithms.layout.SpringLayout;
import edu.uci.ics.jung.algorithms.layout.SpringLayout2;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.Context;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.Layer;
import edu.uci.ics.jung.visualization.RenderContext;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.AbstractModalGraphMouse;
import edu.uci.ics.jung.visualization.control.CrossoverScalingControl;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.GraphMouseListener;
import edu.uci.ics.jung.visualization.control.ScalingControl;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

import edu.uci.ics.jung.visualization.renderers.Renderer;
import edu.uci.ics.jung.visualization.renderers.BasicVertexLabelRenderer.InsidePositioner;

import javax.swing.*;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class graph_creatorV14_final {
	//create the graph
	static DirectedSparseGraph<String, String> graph;
	//load the files
	static String file1="C:/Users/alexandros/Desktop/simasiologikos_istos/ontologies/ka.owl";
	static String file2="C:/Users/alexandros/Desktop/simasiologikos_istos/ontologies/koala.owl";
	static String file3="C:/Users/alexandros/Desktop/simasiologikos_istos/ontologies/leo.owl";
	static String file4="C:/Users/alexandros/Desktop/simasiologikos_istos/ontologies/camera.owl";
	// creation of the tabbed panel
	static VisualizationViewer<String, String> vv;
	JTabbedPane tabbedPane = new JTabbedPane();
	final JFrame frame = new JFrame();
	Container content = frame.getContentPane();
	@SuppressWarnings("unchecked")
	public graph_creatorV14_final(final String pref) {
		int i;

		if(pref.endsWith("s")||pref.endsWith("c")){
			for(i=1;i<=4;i++){
				graph = new DirectedSparseGraph<String, String>();

				axiomanal("*ont"+i+"s");

				// graph creator

				ImageIcon sandstoneIcon = null;

				if (pref.endsWith("s")||pref.endsWith("c")) {
					vv = new VisualizationViewer<String, String>(
							new DAGLayout<String, String>(graph), new Dimension(1200,
									900));
				} else if (pref.endsWith("a")) {
					vv = new VisualizationViewer<String, String>(
							new ISOMLayout<String, String>(graph), new Dimension(1200,
									900));
				}
				vv.setPreferredSize(new Dimension(1200, 900));
				vv.addPostRenderPaintable(new VisualizationViewer.Paintable() {
					int x;
					int y;
					Font font;
					FontMetrics metrics;
					int swidth;
					int sheight;
					String str = "semantic graph";

					public void paint(Graphics g) {
						Dimension d = vv.getSize();
						if (font == null) {
							font = new Font(g.getFont().getName(), Font.BOLD, 30);
							metrics = g.getFontMetrics(font);
							swidth = metrics.stringWidth(str);
							sheight = metrics.getMaxAscent() + metrics.getMaxDescent();
							x = (d.width - swidth) / 2;
							y = (int) (d.height - sheight * 1.5);
						}
						g.setFont(font);
						Color oldColor = g.getColor();
						g.setColor(Color.lightGray);
						g.drawString(str, x, y);
						g.setColor(oldColor);
					}

					public boolean useTransform() {
						return false;
					}
				});

				vv.addGraphMouseListener(new TestGraphMouseListener<String>());


				// vertex shape
				Transformer<String, Shape> vertexSize = new Transformer<String, Shape>() {

					@Override
					public Shape transform(String Vertex) {
						if (Vertex.length() <= 4) {
							Rectangle rect = new Rectangle(-15, -15,
									(Vertex.length() * 12), 30);
							return rect;
						}
						// TODO Auto-generated method stub
						else {
							Rectangle rect = new Rectangle(-15, -15,
									(Vertex.length() * 7), 30);
							return rect;
						}
						// in this case, the vertex is twice as large

					}
				};
				Transformer<String,Paint> vertexColor = new
						Transformer<String,Paint>(){
					@Override
					public Paint transform(String Vertex) {
						String spesvertex="";
						if (pref.endsWith("c")) {
							int i=0;
							int flag=0;
							// loop to find the name of the specific vertex
							for (i = 0; i < pref.length(); i++) {

								if (pref.charAt(i) == '*') {
									flag = 1;
								}
								if (flag == 1 && pref.charAt(i) != '*'
										&& pref.charAt(i) != '!') {
									spesvertex += pref.charAt(i);
								}
								if (pref.charAt(i) == '!') {
									flag = 0;
								}
							}

						}
						//TODO Auto-generated method stub
						if(Vertex.equals(spesvertex)){

							return Color.BLUE;

						}
						else{

							if(Vertex.contains("ont1")){
								return Color.gray;
							}
							if(Vertex.contains("ont2")){
								return Color.cyan;
							}
							if(Vertex.contains("ont3")){
								return Color.LIGHT_GRAY;
							}
							if(Vertex.contains("ont4")){
								return Color.orange;
							}
							else{
								return Color.black;
							}
						}
					}
				};
				Transformer<String, Paint> edgecolor = new Transformer<String, Paint>() {

					@Override
					public Paint transform(String Edge) {
						if (Edge.contains("Disjoint")) {
							return Color.RED;
						} else if (Edge.contains("Equivalent")) {
							return Color.GREEN;
						} else if (Edge.endsWith("*")) {
							return Color.CYAN;
						} 
						else if (Edge.contains("cowl:")) {
							return Color.black;
						}else {
							return Color.GRAY;
						}
					}
				};

				vv.getRenderContext().setVertexFillPaintTransformer(vertexColor);
				vv.getRenderContext().setVertexShapeTransformer(vertexSize);
				vv.getRenderContext().setEdgeDrawPaintTransformer(edgecolor);
				vv.getRenderContext().setArrowFillPaintTransformer(edgecolor);
				vv.getRenderContext().setArrowDrawPaintTransformer(edgecolor);
				vv.getRenderContext().setEdgeStrokeTransformer(
						new ConstantTransformer(new BasicStroke(2f)));
				// add my listeners for ToolTips
				vv.setVertexToolTipTransformer(new Transformer<String, String>() {
					public String transform(String Vertex) {
						String text = "<html>" + axiomanal("*" +Vertex + "!b") + "</html>"; 
						return text;
					}
				});
				vv.setEdgeToolTipTransformer(new Transformer<String, String>() {
					public String transform(String edge) {
						return graph.getSource(edge) + " " + edge + "  "
								+ graph.getDest(edge);
					}
				});

				vv.getRenderContext().setVertexLabelTransformer(
						new ToStringLabeller<String>());
				vv.getRenderer().getVertexLabelRenderer()
				.setPositioner(new InsidePositioner());
				vv.getRenderer().getVertexLabelRenderer()
				.setPosition(Renderer.VertexLabel.Position.CNTR);
				vv.setForeground(Color.BLACK);

				final AbstractModalGraphMouse graphMouse = new DefaultModalGraphMouse<String, String>();
				vv.setGraphMouse(graphMouse);

				vv.addKeyListener(graphMouse.getModeKeyListener());
				vv.setToolTipText("<html><center>Type 'p' for Pick mode<p>Type 't' for Transform mode");

				final ScalingControl scaler = new CrossoverScalingControl();
				// button controlling

				if(i==1){
					final GraphZoomScrollPane panel = new GraphZoomScrollPane(vv);
					tabbedPane.addTab("Ontology1", panel);
					frame.add(tabbedPane, BorderLayout.CENTER);
				}
				if(i==2){
					final GraphZoomScrollPane panel2 = new GraphZoomScrollPane(vv);
					tabbedPane.addTab("Ontology2", panel2);
					frame.add(tabbedPane, BorderLayout.CENTER);
				}
				if(i==3){
					final GraphZoomScrollPane panel3 = new GraphZoomScrollPane(vv);
					tabbedPane.addTab("Ontology3", panel3);
					frame.add(tabbedPane, BorderLayout.CENTER);
					JButton button3 = new JButton("x");
				}
				if(i==4){
					final GraphZoomScrollPane panel4 = new GraphZoomScrollPane(vv);
					tabbedPane.addTab("Ontology4", panel4);
					frame.add(tabbedPane, BorderLayout.CENTER);
					JButton button4 = new JButton("x");
				}
				// checkbox for more complex graph
				// buttons creator for the java window
				JButton plus = new JButton("+");
				plus.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						scaler.scale(vv, 1.1f, vv.getCenter());
					}
				});
				JButton minus = new JButton("-");
				minus.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						scaler.scale(vv, 1 / 1.1f, vv.getCenter());
					}
				});

				JButton reset = new JButton("reset");
				reset.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						vv.getRenderContext().getMultiLayerTransformer()
						.getTransformer(Layer.LAYOUT).setToIdentity();
						vv.getRenderContext().getMultiLayerTransformer()
						.getTransformer(Layer.VIEW).setToIdentity();
					}
				});

				final JTextField searchfield= new JTextField(15);
				JButton search= new JButton("Search");
				search.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						String text1= searchfield.getText();
						System.out.println(text1);
						frame.dispose();
						new graph_creatorV14_final("*" + text1 + "!c");


					}
				});

				JPanel controls = new JPanel();
				controls.add(plus);
				controls.add(minus);
				controls.add(reset);
				controls.add(searchfield);
				controls.add(search);

				content.add(controls, BorderLayout.SOUTH);
				frame.pack();
				frame.setVisible(true);
			}//end of for loop

		}//end of if
		else{
			graph = new DirectedSparseGraph<String, String>();

			axiomanal(pref);

			// graph creator

			ImageIcon sandstoneIcon = null;

			if (pref.endsWith("s")) {
				vv = new VisualizationViewer<String, String>(
						new DAGLayout<String, String>(graph), new Dimension(1200,
								900));
			} else if (pref.endsWith("a")) {
				vv = new VisualizationViewer<String, String>(
						new ISOMLayout<String, String>(graph), new Dimension(1200,
								900));
			}
			vv.setPreferredSize(new Dimension(1200, 900));
			vv.addPostRenderPaintable(new VisualizationViewer.Paintable() {
				int x;
				int y;
				Font font;
				FontMetrics metrics;
				int swidth;
				int sheight;
				String str = "semantic graph";

				public void paint(Graphics g) {
					Dimension d = vv.getSize();
					if (font == null) {
						font = new Font(g.getFont().getName(), Font.BOLD, 30);
						metrics = g.getFontMetrics(font);
						swidth = metrics.stringWidth(str);
						sheight = metrics.getMaxAscent() + metrics.getMaxDescent();
						x = (d.width - swidth) / 2;
						y = (int) (d.height - sheight * 1.5);
					}
					g.setFont(font);
					Color oldColor = g.getColor();
					g.setColor(Color.lightGray);
					g.drawString(str, x, y);
					g.setColor(oldColor);
				}

				public boolean useTransform() {
					return false;
				}
			});

			vv.addGraphMouseListener(new TestGraphMouseListener<String>());


			// vertex shape
			Transformer<String, Shape> vertexSize = new Transformer<String, Shape>() {

				@Override
				public Shape transform(String Vertex) {
					if (Vertex.length() <= 4) {
						Rectangle rect = new Rectangle(-15, -15,
								(Vertex.length() * 12), 30);
						return rect;
					}
					// TODO Auto-generated method stub
					else {
						Rectangle rect = new Rectangle(-15, -15,
								(Vertex.length() * 7), 30);
						return rect;
					}
					// in this case, the vertex is twice as large

				}
			};
			Transformer<String,Paint> vertexColor = new
					Transformer<String,Paint>(){
				@Override
				public Paint transform(String Vertex) {
					String spesvertex="";


					if (pref.endsWith("c")) {


						int i=0;
						int flag=0;
						// loop to find the name of the specific vertex
						for (i = 0; i < pref.length(); i++) {

							if (pref.charAt(i) == '*') {
								flag = 1;
							}
							if (flag == 1 && pref.charAt(i) != '*'
									&& pref.charAt(i) != '!') {
								spesvertex += pref.charAt(i);
							}
							if (pref.charAt(i) == '!') {
								flag = 0;
							}
						}

					}
					//TODO Auto-generated method stub
					if(Vertex.equals(spesvertex)){

						return Color.BLUE;

					}
					else{
						if(Vertex.contains("ont1")){
							return Color.gray;
						}
						if(Vertex.contains("ont2")){
							return Color.cyan;
						}
						if(Vertex.contains("ont3")){
							return Color.LIGHT_GRAY;
						}
						if(Vertex.contains("ont4")){
							return Color.orange;
						}
						else{
							return Color.black;
						}

					}
				}
			};
			Transformer<String, Paint> edgecolor = new Transformer<String, Paint>() {

				@Override
				public Paint transform(String Edge) {
					if (Edge.contains("Disjoint")) {
						return Color.RED;
					} else if (Edge.contains("Equivalent")) {
						return Color.GREEN;
					} else if (Edge.endsWith("*")) {
						return Color.CYAN;
					} 
					else if (Edge.contains("cowl:")) {
						return Color.black;
					}else {
						return Color.GRAY;
					}
				}
			};
			Transformer<String, Stroke> edgestroke = new Transformer<String, Stroke>() {

				@Override
				public Stroke transform(String Edge) {
					float dash[] = {10.0f};

					if (Edge.contains("cowl:")) {

						if(Edge.contains("cowl:subclassof")== false){
							return new BasicStroke(2f,BasicStroke.CAP_BUTT,
									BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);
						}
						else{
							return new BasicStroke(2f);
						}
					}
					else{
						return new BasicStroke(2f);}
				}
			};

			vv.getRenderContext().setVertexFillPaintTransformer(vertexColor);
			vv.getRenderContext().setVertexShapeTransformer(vertexSize);
			vv.getRenderContext().setEdgeDrawPaintTransformer(edgecolor);
			vv.getRenderContext().setArrowFillPaintTransformer(edgecolor);
			vv.getRenderContext().setArrowDrawPaintTransformer(edgecolor);
			vv.getRenderContext().setEdgeStrokeTransformer(edgestroke);
			// add my listeners for ToolTips
			vv.setVertexToolTipTransformer(new Transformer<String, String>() {
				public String transform(String Vertex) {
					String text = "<html>" + axiomanal("*" +Vertex + "!b") + "</html>"; 
					return text;
				}
			});
			vv.setEdgeToolTipTransformer(new Transformer<String, String>() {
				public String transform(String edge) {
					return graph.getSource(edge) + " " + edge + "  "
							+ graph.getDest(edge);
				}
			});

			vv.getRenderContext().setVertexLabelTransformer(
					new ToStringLabeller<String>());
			vv.getRenderer().getVertexLabelRenderer()
			.setPositioner(new InsidePositioner());
			vv.getRenderer().getVertexLabelRenderer()
			.setPosition(Renderer.VertexLabel.Position.CNTR);
			vv.setForeground(Color.BLACK);

			// create a from to hold the graph


			final AbstractModalGraphMouse graphMouse = new DefaultModalGraphMouse<String, String>();
			vv.setGraphMouse(graphMouse);

			vv.addKeyListener(graphMouse.getModeKeyListener());
			vv.setToolTipText("<html><center>Type 'p' for Pick mode<p>Type 't' for Transform mode");

			final ScalingControl scaler = new CrossoverScalingControl();
			// button controlling

			if(pref.contains("ont1")){
				final GraphZoomScrollPane panel = new GraphZoomScrollPane(vv);
				tabbedPane.addTab("Ontology1", panel);
				frame.add(tabbedPane, BorderLayout.CENTER);
				JButton button = new JButton("Ontology1");
			}
			if(pref.contains("ont2")){
				final GraphZoomScrollPane panel2 = new GraphZoomScrollPane(vv);
				tabbedPane.addTab("Ontology2", panel2);
				frame.add(tabbedPane, BorderLayout.CENTER);
				JButton button2 = new JButton("Ontology2");
			}
			if(pref.contains("ont3")){
				final GraphZoomScrollPane panel3 = new GraphZoomScrollPane(vv);
				tabbedPane.addTab("Ontology3", panel3);
				frame.add(tabbedPane, BorderLayout.CENTER);
				JButton button3 = new JButton("Ontology3");
			}
			if(pref.contains("ont4")){
				final GraphZoomScrollPane panel4 = new GraphZoomScrollPane(vv);
				tabbedPane.addTab("Ontology4", panel4);
				frame.add(tabbedPane, BorderLayout.CENTER);
				JButton button4 = new JButton("Ontology4");
			}
			// checkbox for more complex graph



			// buttons creator for the java window
			JButton plus = new JButton("+");
			plus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					scaler.scale(vv, 1.1f, vv.getCenter());
				}
			});
			JButton minus = new JButton("-");
			minus.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					scaler.scale(vv, 1 / 1.1f, vv.getCenter());
				}
			});

			JButton reset = new JButton("reset");
			reset.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					vv.getRenderContext().getMultiLayerTransformer()
					.getTransformer(Layer.LAYOUT).setToIdentity();
					vv.getRenderContext().getMultiLayerTransformer()
					.getTransformer(Layer.VIEW).setToIdentity();
				}
			});

			final JTextField searchfield= new JTextField(15);
			JButton search= new JButton("Search");
			search.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					String text1= searchfield.getText();
					System.out.println(text1);
					JOptionPane.showMessageDialog(null, " ",text1 ,JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();

					new graph_creatorV14_final("*" + text1 + "!c");


				}
			});

			JPanel controls = new JPanel();
			controls.add(plus);
			controls.add(minus);
			controls.add(reset);
			controls.add(searchfield);
			controls.add(search);

			content.add(controls, BorderLayout.SOUTH);

			frame.pack();
			frame.setVisible(true);
		}//end of else
	}

	public static String AxiomtoString(String axiom, int counter) {

		int i;
		int flag = 0;
		int caxiomname = 0;// countaxiomnames
		int caxiom = 0;// count axioms
		int cc = 0;// concept counter
		int inlastc = 0;// flag for the last concept
		int pref = 0;
		int sflag = 0;
		int flagof = 0;//
		int flagprop = 0;// flag to see if a vertex is a property
		int complexity = 0;
		String spesvertex = ""; // if the user clicks a vertex here is where the
		// name is stored
		String[] axioms = { "", "" };// all the axioms
		String[] axiomname = { "" };// all the names of the axioms
		if (axiom.endsWith("s")) {
			pref = 1;
		}

		else if (axiom.endsWith("a")) {
			pref = 2;
			// loop to find the name of the specific vertex
			for (i = 0; i < axiom.length(); i++) {

				if (axiom.charAt(i) == '*') {
					flag = 1;
				}
				if (flag == 1 && axiom.charAt(i) != '*'
						&& axiom.charAt(i) != '!') {
					spesvertex += axiom.charAt(i);
				}
				if (axiom.charAt(i) == '!') {
					flag = 0;
				}
			}
			System.out.println(spesvertex);
		} else if (axiom.endsWith("b")) {
			pref = 3;
			// loop to find the name of the specific vertex
			for (i = 0; i < axiom.length(); i++) {

				if (axiom.charAt(i) == '*') {
					flag = 1;
				}
				if (flag == 1 && axiom.charAt(i) != '*'
						&& axiom.charAt(i) != '!') {
					spesvertex += axiom.charAt(i);
				}
				if (axiom.charAt(i) == '!') {
					flag = 0;
				}
			}
			System.out.println(spesvertex);
		}
		else if (axiom.endsWith("c")) {
			pref = 4;
			// loop to find the name of the specific vertex
			for (i = 0; i < axiom.length(); i++) {

				if (axiom.charAt(i) == '*') {
					flag = 1;
				}
				if (flag == 1 && axiom.charAt(i) != '*'
						&& axiom.charAt(i) != '!') {
					spesvertex += axiom.charAt(i);
				}
				if (axiom.charAt(i) == '!') {
					flag = 0;
				}
			}
			System.out.println(spesvertex);
		}

		// loop only for simple sub
		// classes///////////////////////////////////////////////////////////////////////////////////
		if (pref == 1|| pref==4) {
			if(axiom.contains("ont1")){
				axioms[0]+="ont1:";
				axioms[1]+="ont1:";
			}
			if(axiom.contains("ont2")){
				axioms[0]+="ont2:";
				axioms[1]+="ont2:";
			}
			if(axiom.contains("ont3")){
				axioms[0]+="ont3:";
				axioms[1]+="ont3:";
			}
			if(axiom.contains("ont4")){
				axioms[0]+="ont4:";
				axioms[1]+="ont4:";
			}
			flag = 0;
			for (i = 0; i < axiom.length(); i++) {
				if (axiom.charAt(i) == '*') {
					break;
				}
				if (axiom.charAt(i) == '(') {
					flagof++;
				}
				if (flag == 0) {
					if (axiom.charAt(i) == '(') {
						flag = 1;
					}
					if (axiom.charAt(i) != '(')
						axiomname[0] += axiom.charAt(i);
				}
				if (flag == 1 && axiom.charAt(i) == '#') {
					flag = 2;
				}
				if (flag == 2) {
					if ((axiom.charAt(i) != '#') && (axiom.charAt(i) != '>')) {
						axioms[0] += axiom.charAt(i);
					}
				}

				if (flag == 2 && axiom.charAt(i) == '>') {

					flag = 3;
				}
				if (flag == 3 && axiom.charAt(i) == '#') {
					flag = 4;
				}
				if (flag == 4) {
					if ((axiom.charAt(i) != '#') && (axiom.charAt(i) != '>')
							&& (axiom.charAt(i) != ')')) {
						axioms[1] += axiom.charAt(i);
					}
				}

				if ((flag == 3 && flagof == 2)
						|| (axiomname[0].contains("Object"))
						|| (axiomname[0].contains("Data"))) {
					flag = 10;
					System.out.println("done!");
					break;
				}

			}

			System.out.println(axiomname[0] + "----->" + axioms[0] + "-----"
					+ axioms[1]);
			if (flag != 10) {


				graph.addEdge(axiomname[0] + counter + i, axioms[0], axioms[1],
						EdgeType.DIRECTED);
			}

		}// end of simple class graph creator

		// Specific vertex graph
		// creator//////////////////////////////////////////////////////////////////////////////////////////////
		if (pref == 2 || pref == 3) {
			// testing for specific

			// variables


			flag = 0;
			caxiomname = 0;// countaxiomnames
			caxiom = 0;// count axioms
			cc = 0;// concept counter
			inlastc = 0;// flag for the last concept

			// if the user clicks a vertex here is where the name is stored
			String[] axioms2 = { "", "", "", "", "", "", "", "", "", "", "",
					"", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
					"", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
					"", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
					"", "", "", "", "", "" };// ola ta axiomata
			String[] axiomname2 = { "", "", "", "", "", "", "", "", "", "", "",
					"", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
					"", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
					"", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
					"", "", "", "", "", "" };// ola ta onomata axiomaton
			// end of variables
			flag = 0;
			if(axiom.contains("ont1")){
				axioms2[0]+="ont1:";
				axioms2[1]+="ont1:";
				axioms2[2]+="ont1:";
			}
			if(axiom.contains("ont2")){
				axioms2[0]+="ont2:";
				axioms2[1]+="ont2:";
				axioms2[2]+="ont2:";
			}
			if(axiom.contains("ont3")){
				axioms2[0]+="ont3:";
				axioms2[1]+="ont3:";
				axioms2[2]+="ont3:";
			}
			if(axiom.contains("ont4")){
				axioms2[0]+="ont4:";
				axioms2[1]+="ont4:";
				axioms2[2]+="ont4:";
			}
			int firsttime = 0;
			for (i = 0; i < axiom.length(); i++) {
				if (axiom.charAt(i) == '*') {
					break;
				}
				if (axiom.charAt(i) == ' ') {
					continue;
				}

				if (flag == 0) {
					// Don't put ) character in the name
					if (axiom.charAt(i) != '(') {
						if (caxiomname == 1 && firsttime == 1) {
							firsttime = 0;
							axiomname2[caxiomname] += axiom.charAt(i - 1);
						}
						axiomname2[caxiomname] += axiom.charAt(i);
					}
				}
				if (axiom.charAt(i) == '(') {
					firsttime = 1;
					caxiomname++;
					flag = 1;
				}
				// detection where the axiom starts
				if (flag == 1 && axiom.charAt(i) == '#') {
					flag = 2;
				}
				if (flag == 2) {
					// only letters in the name(not #,>)
					if (axiom.charAt(i) != '#' && axiom.charAt(i) != '>') {
						axioms2[caxiom] += axiom.charAt(i);
					}
				}
				if (flag == 2 && axiom.charAt(i) == '>') {
					if (axioms2[caxiom].equals(spesvertex)) {
						sflag = 1;
					}
					caxiom++;
					flag = 3;
					continue;
				}
				if (flag == 3 && complexity == 2) {
					flag = 1;
				}

				if (flag == 3 && caxiom == 1 && axiom.charAt(i) == '<'
						&& complexity == 0) {
					complexity = 1;
					flag = 1;
					System.out.println("in1");
				}
				if (flag == 3 && caxiom == 1 && axiom.charAt(i) != '<'
						&& complexity == 0) {
					System.out.println("in2");
					complexity = 2;
					flag = 0;
				}

				cc++;
			}// end of for loop
			if (complexity == 1 && sflag == 1) {
				System.out.println(axiomname2[0] + "----->" + axioms2[0]
						+ "-----" + axioms2[1]);
				if (pref == 2) {

					graph.addEdge(axiomname2[0] + counter + cc, axioms2[0],
							axioms2[1], EdgeType.DIRECTED);
				}
				if (pref == 3) {
					return "<b>"+axioms2[0]+"</b>" + " " + axiomname2[0] + " " +"<b>" +axioms2[1]
							+ "</b><br>";
				}
			} else if (complexity == 2 && sflag == 1) {
				if (axiomname2[1].contains("ata") != true) {
					if (pref == 2) {

						graph.addEdge(axioms2[1] + " ( " + axiomname2[0] + " "
								+ axiomname2[1] + " )   " + counter + cc + "*",
								axioms2[0], axioms2[2], EdgeType.DIRECTED);
					}
					System.out.println("----------------------" + axioms2[2]);

					if (pref == 3) {
						return "<b>"+axioms2[0]+"</b>" + " " + axioms2[1] + " ( "
								+ axiomname2[0] + " " + axiomname2[1] + " ) "
								+"<b>"+axioms2[2]+"</b>" + "<br>";
					}
				}
			}


		}// end if preference=2

		//formalism!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!



		return "void";		//end of formalism!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	}// end of axiom to string
	// labeling on mouse over function for individual vertex graph

	static class TestGraphMouseListener<V> implements GraphMouseListener<V> {

		public void graphClicked(V v, MouseEvent me) {
			System.err.println("Vertex " + v + " was clicked at (" + me.getX()
					+ "," + me.getY() + ")");
			JOptionPane.showMessageDialog(null, "vertex " + v + " is clicked",
					"was clicked at (" + me.getX() + "," + me.getY() + ")",
					JOptionPane.INFORMATION_MESSAGE);
			graph = new DirectedSparseGraph<String, String>();
			vv.getRenderContext().getMultiLayerTransformer()
			.getTransformer(Layer.LAYOUT).setToIdentity();
			vv.getRenderContext().getMultiLayerTransformer()
			.getTransformer(Layer.VIEW).setToIdentity();
			new graph_creatorV14_final("*" + v + "!a");
		}

		public void graphPressed(V v, MouseEvent me) {
			System.err.println("Vertex " + v + " was pressed at (" + me.getX()
					+ "," + me.getY() + ")");
			System.err.println();
		}

		public void graphReleased(V v, MouseEvent me) {
			System.err.println("Vertex " + v + " was released at (" + me.getX()
					+ "," + me.getY() + ")");
		}
	}

	// and of class

	public static String axiomanal(String pref) {
		// tripletes me axiomata se ena pinaka
		String Allvalues = "";
		String filepath ="";
		if (pref.contains("ont1")){
			filepath=file1;
		}
		if (pref.contains("ont2")){
			filepath= file2;
		}
		if (pref.contains("ont3")){
			filepath=file3;
		}
		if (pref.contains("ont4")){
			filepath=file4;
		}
		// Try to load the ontologie from an internal file.

		try {
			// variables
			int counter = 0;
			int i;
			int flag=0;
			String spesvertex="";
			// Create a file chooser
			// JFileChooser chooser = new JFileChooser();

			// Component parent = null;

			// load ontologie

			//cowl graph creator//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			if(pref.endsWith("a")){
				for (i = 0; i < pref.length(); i++) {

					if (pref.charAt(i) == '*') {
						flag = 1;
					}
					if (flag == 1 && pref.charAt(i) != '*'
							&& pref.charAt(i) != '!') {
						spesvertex += pref.charAt(i);
					}
					if (pref.charAt(i) == '!') {
						flag = 0;
					}
				}
				try {
					i=0;
					flag=0;

					
					File fXmlFile = new File("C:/Users/alexandros/Desktop/unit1.cowl");
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document doc = dBuilder.parse(fXmlFile);
					String sourceont="";//string that stores the path of source ontology
					String targetont="";//string that stores the path of target ontology
					String sourcefile="";//string that stores the path of source ontology
					String targetfile="";//string that stores the path of target ontology
					String prop_rest =" ";// string that stores the role between concepts
					doc.getDocumentElement().normalize();

					//end connection classes
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					NodeList nList3 = doc.getElementsByTagName("cowl:Onto"); 
					for (int temp = 0; temp < nList3.getLength(); temp++) {
						flag=0;
						Element node = (Element)nList3.item(temp);
						sourceont="";
						targetont="";
						sourcefile="";
						targetfile="";
						System.out.println("\nCurrent Element :" + node.getNodeName());
						NodeList classes = node.getElementsByTagName("owl:Class");
						Element source = (Element) classes.item(0);
						Element target = (Element) classes.item(1);
						System.out.println(source.getAttribute("rdf:about")+" sub class of " +target.getAttribute("rdf:about"));
						for(i=source.getAttribute("rdf:about").length()-1;i>=0;i--){
							if(flag==1&&source.getAttribute("rdf:about").charAt(i)!='/'){
								sourcefile+=source.getAttribute("rdf:about").charAt(i);
							}
							if(source.getAttribute("rdf:about").charAt(i)=='#'){
								flag=1;
							}
							if(source.getAttribute("rdf:about").charAt(i)=='/'){
								flag=0;
							}
						}
						flag=0;
						sourcefile=new StringBuilder(sourcefile).reverse().toString();
						System.out.println(sourcefile);
						if(sourcefile.equals(filename(file1))){
							sourceont+="ont1:";
						}
						if(sourcefile.equals(filename(file2))){
							sourceont+="ont2:";
						}
						if(sourcefile.equals(filename(file3))){
							sourceont+="ont3:";
						}
						if(sourcefile.equals(filename(file4))){
							sourceont+="ont4:";

						}
						System.out.println(sourcefile);
						for(i=target.getAttribute("rdf:about").length()-1;i>=0;i--){
							if(flag==1&&target.getAttribute("rdf:about").charAt(i)!='/'){
								targetfile+=target.getAttribute("rdf:about").charAt(i);
							}
							if(target.getAttribute("rdf:about").charAt(i)=='#'){
								flag=1;
							}
							if(target.getAttribute("rdf:about").charAt(i)=='/'){
								flag=0;
							}
						}
						flag=0;
						targetfile=new StringBuilder(targetfile).reverse().toString();
						if(targetfile.equals(filename(file1))){
							targetont+="ont1:";
						}
						if(targetfile.equals(filename(file2))){
							targetont+="ont2:";
						}
						if(targetfile.equals(filename(file3))){
							targetont+="ont3:";
						}
						if(targetfile.equals(filename(file4))){
							targetont+="ont4:";

						}
						System.out.println(targetfile);
						for(i=0;i<source.getAttribute("rdf:about").length();i++){
							if (flag==1){
								sourceont+=source.getAttribute("rdf:about").charAt(i);

							}
							if(source.getAttribute("rdf:about").charAt(i)=='#'){
								flag=1;
							}
						}

						flag=0;
						for(i=0;i<target.getAttribute("rdf:about").length();i++){
							if (flag==1){
								targetont+=target.getAttribute("rdf:about").charAt(i);

							}
							if(target.getAttribute("rdf:about").charAt(i)=='#'){
								flag=1;
							}
						}
						if(sourceont.equals(spesvertex)||targetont.equals(spesvertex)){
							System.out.println("------------"+sourceont+"  cowl:subclassof  "+targetont);
							graph.addEdge("cowl:subclassof"+temp+i,sourceont,targetont);
						}
					}
					//cowl complex concept manipulation
					NodeList nList31 = doc.getElementsByTagName("owl:Class"); 
					for (int temp = 0; temp < nList31.getLength(); temp++) {
						flag=0;
						Element node = (Element)nList31.item(temp);
						sourceont="";
						targetont="";
						sourcefile="";
						targetfile="";
						prop_rest="";
						NodeList lnode2 = node.getChildNodes();
						System.out.println(lnode2.getLength()); 
						if(lnode2.getLength()==3){
							Element class1 = (Element)nList31.item(temp);
							//find ontology of source class
							for(i=class1.getAttribute("rdf:about").length()-1;i>=0;i--){
								if(flag==1&&class1.getAttribute("rdf:about").charAt(i)!='/'){
									sourcefile+=class1.getAttribute("rdf:about").charAt(i);
								}
								if(class1.getAttribute("rdf:about").charAt(i)=='#'){
									flag=1;
								}
								if(class1.getAttribute("rdf:about").charAt(i)=='/'){
									flag=0;
								}
							}
							flag=0;
							sourcefile=new StringBuilder(sourcefile).reverse().toString();

							if(sourcefile.equals(filename(file1))){
								sourceont+="ont1:";
							}
							if(sourcefile.equals(filename(file2))){
								sourceont+="ont2:";
							}
							if(sourcefile.equals(filename(file3))){
								sourceont+="ont3:";
							}
							if(sourcefile.equals(filename(file4))){
								sourceont+="ont4:";

							}
							//end of finding ontology
							for(i=0;i<class1.getAttribute("rdf:about").length();i++){
								if (flag==1){
									sourceont+=class1.getAttribute("rdf:about").charAt(i);

								}
								if(class1.getAttribute("rdf:about").charAt(i)=='#'){
									flag=1;
								}
							}

							flag=0;
							Element node3 =(Element) lnode2.item(1);
							prop_rest += node3.getTagName();
							prop_rest+="  (";
							NodeList lnode3 =node3.getChildNodes();
							Node node4 = lnode3.item(1);
							NodeList lnode4 =node4.getChildNodes();
							Element node5 =(Element) lnode4.item(1);
							for(i=0;i<node5.getAttribute("rdf:resource").length();i++){
								if (flag==1){
									prop_rest+=node5.getAttribute("rdf:resource").charAt(i);

								}
								if(node5.getAttribute("rdf:resource").charAt(i)=='#'){
									flag=1;
								}
							}

							flag=0;
							prop_rest+="  ";
							Element node6 =(Element)lnode4.item(3);
							prop_rest += node6.getNodeName();
							prop_rest+=" )";
							//find the ontology of target class
							for(i=node6.getAttribute("rdf:resource").length()-1;i>=0;i--){
								if(flag==1&&node6.getAttribute("rdf:resource").charAt(i)!='/'){
									targetfile+=node6.getAttribute("rdf:resource").charAt(i);
								}
								if(node6.getAttribute("rdf:resource").charAt(i)=='#'){
									flag=1;
								}
								if(node6.getAttribute("rdf:resource").charAt(i)=='/'){
									flag=0;
								}
							}
							flag=0;
							targetfile=new StringBuilder(targetfile).reverse().toString();

							if(targetfile.equals(filename(file1))){
								targetont+="ont1:";
							}
							if(targetfile.equals(filename(file2))){
								targetont+="ont2:";
							}
							if(targetfile.equals(filename(file3))){
								targetont+="ont3:";
							}
							if(targetfile.equals(filename(file4))){
								targetont+="ont4:";

							}
							//end of find class
							for(i=0;i<node6.getAttribute("rdf:resource").length();i++){
								if (flag==1){
									targetont+=node6.getAttribute("rdf:resource").charAt(i);

								}
								if(node6.getAttribute("rdf:resource").charAt(i)=='#'){
									flag=1;
								}
							}
							flag=0;
							if(sourceont.equals(spesvertex)||targetont.equals(spesvertex)){
								System.out.println(sourceont+"-----"+prop_rest+"-----"+ targetont);
								graph.addEdge("cowl:"+prop_rest+temp+i,sourceont,targetont);
							}
						}
					}
					//end of complex concept manipulation

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			//end of cowl grapf creator/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			String inputFile = filepath;
			OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
			File iFile = new File(inputFile);
			OWLOntology ont = manager.loadOntologyFromOntologyDocument(iFile);
			// see if it works and print it
			System.out.println("ontology: " + ont.toString());

			// process the ontologie
			// summing all the logical axioms of the ontology
			for (OWLAxiom a : ont.getLogicalAxioms())// putting in variable all
			{


				counter++;
				// CHECK all possible types of OWL Axioms
				if (a instanceof OWLAsymmetricObjectPropertyAxiom) {
					OWLAsymmetricObjectPropertyAxiom owlaxiom1 = (OWLAsymmetricObjectPropertyAxiom) a;
					System.out.println(owlaxiom1);
					if (AxiomtoString(owlaxiom1.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(owlaxiom1.toString() + pref,
								counter);

				}
				if (a instanceof OWLDataPropertyCharacteristicAxiom) {
					OWLDataPropertyCharacteristicAxiom owlaxiom2 = (OWLDataPropertyCharacteristicAxiom) a;
					System.out.println(owlaxiom2);
					if (AxiomtoString(owlaxiom2.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(owlaxiom2.toString() + pref,
								counter);

				}
				if (a instanceof OWLDataPropertyDomainAxiom) {
					OWLDataPropertyDomainAxiom owlaxiom3 = (OWLDataPropertyDomainAxiom) a;
					System.out.println(owlaxiom3);
					if (AxiomtoString(owlaxiom3.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(owlaxiom3.toString() + pref,
								counter);

				}
				if (a instanceof OWLDataPropertyRangeAxiom) {
					OWLDataPropertyRangeAxiom owlaxiom4 = (OWLDataPropertyRangeAxiom) a;
					System.out.println(owlaxiom4);
					if (AxiomtoString(owlaxiom4.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(owlaxiom4.toString() + pref,
								counter);

				}
				if (a instanceof OWLDatatypeDefinitionAxiom) {
					OWLDatatypeDefinitionAxiom owlaxiom5 = (OWLDatatypeDefinitionAxiom) a;
					System.out.println(owlaxiom5);
					if (AxiomtoString(owlaxiom5.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(owlaxiom5.toString() + pref,
								counter);

				}
				if (a instanceof OWLDifferentIndividualsAxiom) {
					OWLDifferentIndividualsAxiom owlaxiom6 = (OWLDifferentIndividualsAxiom) a;
					System.out.println(owlaxiom6);
					if (AxiomtoString(owlaxiom6.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(owlaxiom6.toString() + pref,
								counter);

				}
				if (a instanceof OWLDisjointClassesAxiom) {
					OWLDisjointClassesAxiom owlaxiom7 = (OWLDisjointClassesAxiom) a;
					System.out.println(owlaxiom7);
					if (AxiomtoString(owlaxiom7.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(owlaxiom7.toString() + pref,
								counter);

				}
				if (a instanceof OWLDisjointDataPropertiesAxiom) {
					OWLDisjointDataPropertiesAxiom owlaxiom8 = (OWLDisjointDataPropertiesAxiom) a;
					System.out.println(owlaxiom8);
					if (AxiomtoString(owlaxiom8.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(owlaxiom8.toString() + pref,
								counter);

				}
				if (a instanceof OWLDisjointObjectPropertiesAxiom) {
					OWLDisjointObjectPropertiesAxiom owlaxiom9 = (OWLDisjointObjectPropertiesAxiom) a;
					System.out.println(owlaxiom9);
					if (AxiomtoString(owlaxiom9.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(owlaxiom9.toString() + pref,
								counter);

				}
				if (a instanceof OWLDisjointUnionAxiom) {
					OWLDisjointUnionAxiom owlaxiom10 = (OWLDisjointUnionAxiom) a;
					System.out.println(owlaxiom10);
					if (AxiomtoString(owlaxiom10.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(
								owlaxiom10.toString() + pref, counter);

				}
				if (a instanceof OWLEquivalentClassesAxiom) {
					OWLEquivalentClassesAxiom owlaxiom11 = (OWLEquivalentClassesAxiom) a;
					System.out.println(owlaxiom11);
					if (AxiomtoString(owlaxiom11.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(
								owlaxiom11.toString() + pref, counter);

				}
				if (a instanceof OWLEquivalentDataPropertiesAxiom) {
					OWLEquivalentDataPropertiesAxiom owlaxiom12 = (OWLEquivalentDataPropertiesAxiom) a;
					System.out.println(owlaxiom12);
					if (AxiomtoString(owlaxiom12.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(
								owlaxiom12.toString() + pref, counter);

				}
				if (a instanceof OWLEquivalentObjectPropertiesAxiom) {
					OWLEquivalentObjectPropertiesAxiom owlaxiom13 = (OWLEquivalentObjectPropertiesAxiom) a;
					System.out.println(owlaxiom13);
					if (AxiomtoString(owlaxiom13.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(
								owlaxiom13.toString() + pref, counter);
				}

				if (a instanceof OWLFunctionalDataPropertyAxiom) {
					OWLFunctionalDataPropertyAxiom owlaxiom14 = (OWLFunctionalDataPropertyAxiom) a;
					System.out.println(owlaxiom14);
					if (AxiomtoString(owlaxiom14.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(
								owlaxiom14.toString() + pref, counter);

				}
				if (a instanceof OWLFunctionalObjectPropertyAxiom) {
					OWLFunctionalObjectPropertyAxiom owlaxiom15 = (OWLFunctionalObjectPropertyAxiom) a;
					System.out.println(owlaxiom15);
					if (AxiomtoString(owlaxiom15.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(
								owlaxiom15.toString() + pref, counter);

				}
				if (a instanceof OWLHasKeyAxiom) {
					OWLHasKeyAxiom owlaxiom16 = (OWLHasKeyAxiom) a;
					System.out.println(owlaxiom16);
					if (AxiomtoString(owlaxiom16.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(
								owlaxiom16.toString() + pref, counter);

				}
				if (a instanceof OWLInverseFunctionalObjectPropertyAxiom) {
					OWLInverseFunctionalObjectPropertyAxiom owlaxiom17 = (OWLInverseFunctionalObjectPropertyAxiom) a;
					System.out.println(owlaxiom17);
					if (AxiomtoString(owlaxiom17.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(
								owlaxiom17.toString() + pref, counter);

				}
				if (a instanceof OWLInverseObjectPropertiesAxiom) {
					OWLInverseObjectPropertiesAxiom owlaxiom18 = (OWLInverseObjectPropertiesAxiom) a;
					System.out.println(owlaxiom18);
					if (AxiomtoString(owlaxiom18.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(
								owlaxiom18.toString() + pref, counter);
				}
				if (a instanceof OWLIrreflexiveObjectPropertyAxiom) {
					OWLIrreflexiveObjectPropertyAxiom owlaxiom19 = (OWLIrreflexiveObjectPropertyAxiom) a;
					System.out.println(owlaxiom19);
					if (AxiomtoString(owlaxiom19.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(
								owlaxiom19.toString() + pref, counter);

				}
				if (a instanceof OWLObjectPropertyCharacteristicAxiom) {
					OWLObjectPropertyCharacteristicAxiom owlaxiom20 = (OWLObjectPropertyCharacteristicAxiom) a;
					System.out.println(owlaxiom20);
					if (AxiomtoString(owlaxiom20.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(
								owlaxiom20.toString() + pref, counter);

				}
				if (a instanceof OWLObjectPropertyDomainAxiom) {
					OWLObjectPropertyDomainAxiom owlaxiom21 = (OWLObjectPropertyDomainAxiom) a;
					System.out.println(owlaxiom21);
					if (AxiomtoString(owlaxiom21.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(
								owlaxiom21.toString() + pref, counter);

				}
				if (a instanceof OWLObjectPropertyRangeAxiom) {
					OWLObjectPropertyRangeAxiom owlaxiom22 = (OWLObjectPropertyRangeAxiom) a;
					System.out.println(owlaxiom22);
					if (AxiomtoString(owlaxiom22.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(
								owlaxiom22.toString() + pref, counter);

				}
				if (a instanceof OWLReflexiveObjectPropertyAxiom) {
					OWLReflexiveObjectPropertyAxiom owlaxiom23 = (OWLReflexiveObjectPropertyAxiom) a;
					System.out.println(owlaxiom23);
					if (AxiomtoString(owlaxiom23.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(
								owlaxiom23.toString() + pref, counter);

				}
				if (a instanceof OWLSameIndividualAxiom) {
					OWLSameIndividualAxiom owlaxiom24 = (OWLSameIndividualAxiom) a;
					System.out.println(owlaxiom24);
					if (AxiomtoString(owlaxiom24.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(
								owlaxiom24.toString() + pref, counter);

				}
				// sub objects, the objects that need both end recursion
				//
				//
				//
				if (a instanceof OWLSubClassOfAxiom) {
					OWLSubClassOfAxiom owlaxiom25 = (OWLSubClassOfAxiom) a;
					System.out.println(owlaxiom25);
					if (AxiomtoString(owlaxiom25.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(
								owlaxiom25.toString() + pref, counter);
					// parse the axiom to analyze all the concepts inside
				}
				if (a instanceof OWLSubDataPropertyOfAxiom) {
					OWLSubDataPropertyOfAxiom owlaxiom26 = (OWLSubDataPropertyOfAxiom) a;
					System.out.println(owlaxiom26);
					if (AxiomtoString(owlaxiom26.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(
								owlaxiom26.toString() + pref, counter);
					// parse the axiom to analyze all the concepts inside
				}
				if (a instanceof OWLSubObjectPropertyOfAxiom) {
					OWLSubObjectPropertyOfAxiom owlaxiom27 = (OWLSubObjectPropertyOfAxiom) a;
					System.out.println(owlaxiom27);
					if (AxiomtoString(owlaxiom27.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(
								owlaxiom27.toString() + pref, counter);
					// parse the axiom to analyze all the concepts inside
				}
				if (a instanceof OWLSubPropertyChainOfAxiom) {
					OWLSubPropertyChainOfAxiom owlaxiom28 = (OWLSubPropertyChainOfAxiom) a;
					System.out.println(owlaxiom28);
					if (AxiomtoString(owlaxiom28.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(
								owlaxiom28.toString() + pref, counter);
					// parse the axiom to analyze all the concepts inside

				}
				if (a instanceof OWLSymmetricObjectPropertyAxiom) {
					OWLSymmetricObjectPropertyAxiom owlaxiom29 = (OWLSymmetricObjectPropertyAxiom) a;
					System.out.println(owlaxiom29);
					if (AxiomtoString(owlaxiom29.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(
								owlaxiom29.toString() + pref, counter);

				}
				if (a instanceof OWLTransitiveObjectPropertyAxiom) {
					OWLTransitiveObjectPropertyAxiom owlaxiom30 = (OWLTransitiveObjectPropertyAxiom) a;
					System.out.println(owlaxiom30);
					if (AxiomtoString(owlaxiom30.toString() + pref, counter)
							.equals("void") == false)
						Allvalues += AxiomtoString(
								owlaxiom30.toString() + pref, counter);
				}
			}// end the for loop for all the logicalAxioms
			System.out.println(Allvalues);
			return Allvalues;
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
			return "Problem accured!";
		}
	}
	//finds the name of the file inside the path
	public static String filename(String filepath) {
		int flag=0;
		int i;
		String filename = "";
		for(i=filepath.length()-1;i>=0;i--){
			if (flag==0&&filepath.charAt(i)!='/'){
				filename+=filepath.charAt(i);
			}
			if(filepath.charAt(i)=='/'){
				flag=1;
			}

		}
		filename=new StringBuilder(filename).reverse().toString();

		System.out.println("filename$"+filename);
		return filename;

	}
	public static void main(String[] args) {

		new graph_creatorV14_final("*ont1s");

	}
}
