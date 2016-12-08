package com.tuananh.myATRC;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.io.Reader;
//import java.util.HashMap;
//
//import javax.swing.text.TableView.TableRow;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.forms.widgets.FormToolkit;
//import org.eclipse.ui.internal.dnd.SwtUtil;
//
//import com.microsoft.z3.BoolExpr;
//import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;
//import com.microsoft.z3.IntExpr;
//import com.microsoft.z3.Solver;
//import com.microsoft.z3.Status;
import com.microsoft.z3.Z3Exception;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
//import org.eclipse.swt.widgets.List;
//import org.eclipse.jface.viewers.ListViewer;
//import org.eclipse.swt.widgets.Table;
//import org.eclipse.swt.widgets.TableItem;
//import org.eclipse.swt.widgets.TableColumn;

public class Main_Window
{

	/**
	 * @uml.property  name="shlConsistencyValidating"
	 * @uml.associationEnd  
	 */
	protected Shell shlConsistencyValidating;
	/**
	 * @uml.property  name="lblNewLabel"
	 * @uml.associationEnd  
	 */
	private Label lblNewLabel;
	/**
	 * @uml.property  name="lblNewLabel_1"
	 * @uml.associationEnd  
	 */
	private Label lblNewLabel_1;
	/**
	 * @uml.property  name="lblNewLabel_2"
	 * @uml.associationEnd  
	 */
	private Label lblNewLabel_2;
	/**
	 * @uml.property  name="lblNewLabel_3"
	 * @uml.associationEnd  
	 */
	private Label lblNewLabel_3;
	/**
	 * @uml.property  name="btnResult"
	 * @uml.associationEnd  
	 */
	private Button btnResult;
	/**
	 * @uml.property  name="btnExit"
	 * @uml.associationEnd  
	 */
	private Button btnExit;
	/**
	 * @uml.property  name="lblEvolutionInvarants"
	 * @uml.associationEnd  
	 */
	private Label lblEvolutionInvarants;
	/**
	 * @uml.property  name="formToolkit"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	/**
	 * @uml.property  name="tIniInvarants"
	 * @uml.associationEnd  
	 */
	private Text tIniInvarants;
	/**
	 * @uml.property  name="tIniPreconditions"
	 * @uml.associationEnd  
	 */
	private Text tIniPreconditions;
	/**
	 * @uml.property  name="tIniPostconditions"
	 * @uml.associationEnd  
	 */
	private Text tIniPostconditions;
	/**
	 * @uml.property  name="tEvoPreconditions"
	 * @uml.associationEnd  
	 */
	private Text tEvoPreconditions;
	/**
	 * @uml.property  name="tEvoInvarants"
	 * @uml.associationEnd  
	 */
	private Text tEvoInvarants;
	/**
	 * @uml.property  name="tEvoPostconditions"
	 * @uml.associationEnd  
	 */
	private Text tEvoPostconditions;
	/**
	 * @uml.property  name="lblInitialInvarants"
	 * @uml.associationEnd  
	 */
	private Label lblInitialInvarants;
	/**
	 * @uml.property  name="btnInitialPreconditionVariables"
	 * @uml.associationEnd  
	 */
	private Button btnInitialPreconditionVariables;
	/**
	 * @uml.property  name="btnEvolutionPreconditionVariable"
	 * @uml.associationEnd  
	 */
	private Button btnEvolutionPreconditionVariable;
	/**
	 * @uml.property  name="btnInitialPostconditionVariables"
	 * @uml.associationEnd  
	 */
	private Button btnInitialPostconditionVariables;
	/**
	 * @uml.property  name="btnEvolutionPostconditionVariables"
	 * @uml.associationEnd  
	 */
	private Button btnEvolutionPostconditionVariables;

	/**
	 * @uml.property  name="validator"
	 * @uml.associationEnd  
	 */
	public Validator validator;
	/**
	 * @uml.property  name="btnCheckPreconditions"
	 * @uml.associationEnd  
	 */
	private Button btnCheckPreconditions;
	/**
	 * @uml.property  name="btnCheckPostconditions"
	 * @uml.associationEnd  
	 */
	private Button btnCheckPostconditions;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			Main_Window window = new Main_Window();
			window.open();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open()
	{
		Display display = Display.getDefault();
		createContents();
		shlConsistencyValidating.open();
		shlConsistencyValidating.layout();
		while (!shlConsistencyValidating.isDisposed())
		{
			if (!display.readAndDispatch())
			{
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents()
	{
		validator = new Validator();
		shlConsistencyValidating = new Shell();
		shlConsistencyValidating.setMinimumSize(new Point(800, 480));
		shlConsistencyValidating.setSize(801, 454);
		shlConsistencyValidating.setText("Consistency Validator");
		GridLayout gl_shlConsistencyValidating = new GridLayout(5, false);
		gl_shlConsistencyValidating.marginRight = 4;
		gl_shlConsistencyValidating.marginLeft = 4;
		gl_shlConsistencyValidating.marginTop = 4;
		gl_shlConsistencyValidating.marginBottom = 4;
		gl_shlConsistencyValidating.verticalSpacing = 0;
		shlConsistencyValidating.setLayout(gl_shlConsistencyValidating);
		
				lblInitialInvarants = new Label(shlConsistencyValidating, SWT.WRAP|SWT.CENTER);
				GridData gd_lblInitialInvarants = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
				gd_lblInitialInvarants.widthHint = 71;
				lblInitialInvarants.setLayoutData(gd_lblInitialInvarants);
				//formToolkit.adapt(lblInitialInvarants, true, true);
				lblInitialInvarants.setText("Initial Invarants");
				
						tIniInvarants = new Text(shlConsistencyValidating,
								SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
						GridData gd_tIniInvarants = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
						gd_tIniInvarants.heightHint = 65;
						gd_tIniInvarants.widthHint = 215;
						tIniInvarants.setLayoutData(gd_tIniInvarants);
						formToolkit.adapt(tIniInvarants, true, true);
				
						lblEvolutionInvarants = new Label(shlConsistencyValidating, SWT.WRAP);
						GridData gd_lblEvolutionInvarants = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
						gd_lblEvolutionInvarants.widthHint = 53;
						lblEvolutionInvarants.setLayoutData(gd_lblEvolutionInvarants);
						lblEvolutionInvarants.setText("Evolution Invarants");
				
						tEvoInvarants = new Text(shlConsistencyValidating,
								SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
						GridData gd_tEvoInvarants = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
						gd_tEvoInvarants.widthHint = 191;
						gd_tEvoInvarants.heightHint = 61;
						tEvoInvarants.setLayoutData(gd_tEvoInvarants);
						formToolkit.adapt(tEvoInvarants, true, true);
		new Label(shlConsistencyValidating, SWT.NONE);
		
				lblNewLabel = new Label(shlConsistencyValidating, SWT.WRAP);
				lblNewLabel.setAlignment(SWT.CENTER);
				GridData gd_lblNewLabel = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
				gd_lblNewLabel.widthHint = 73;
				lblNewLabel.setLayoutData(gd_lblNewLabel);
				
				lblNewLabel.setText("Initial Preconditions");
				
						tIniPreconditions = new Text(shlConsistencyValidating,
								SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
						GridData gd_tIniPreconditions = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
						gd_tIniPreconditions.heightHint = 89;
						gd_tIniPreconditions.widthHint = 215;
						tIniPreconditions.setLayoutData(gd_tIniPreconditions);
						formToolkit.adapt(tIniPreconditions, true, true);
				
						lblNewLabel_1 = new Label(shlConsistencyValidating, SWT.WRAP);
						lblNewLabel_1.setAlignment(SWT.CENTER);
						GridData gd_lblNewLabel_1 = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
						gd_lblNewLabel_1.widthHint = 78;
						lblNewLabel_1.setLayoutData(gd_lblNewLabel_1);
						lblNewLabel_1.setText("Evolution Preconditions");
				
						tEvoPreconditions = new Text(shlConsistencyValidating,
								SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
						GridData gd_tEvoPreconditions = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
						gd_tEvoPreconditions.widthHint = 191;
						gd_tEvoPreconditions.heightHint = 103;
						tEvoPreconditions.setLayoutData(gd_tEvoPreconditions);
						formToolkit.adapt(tEvoPreconditions, true, true);
		
		btnCheckPreconditions =  new Button(shlConsistencyValidating, SWT.BORDER | SWT.CENTER|SWT.WRAP);
		btnCheckPreconditions.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(Data.getInstance().iniPre.variables==null
						||Data.getInstance().evoPre.variables==null)
				{
					MessageBox r = new MessageBox(shlConsistencyValidating, SWT.CENTER|SWT.OK|SWT.ICON_ERROR);
					r.setText("Missing variables");
					r.setMessage("Some of variable was not set");
					r.open();
				}
				else
				{
				Expr iniPrecondition = Data.getInstance().iniPre.generateExpr(Data.getInstance().ctx);
				//Expr iniPostcondition =Data.getInstance().iniPost.generateExpr(Data.getInstance().ctx);
				Expr evoPrecondition = Data.getInstance().evoPre.generateExpr(Data.getInstance().ctx);
				//Expr evoPostcondition =Data.getInstance().evoPost.generateExpr(Data.getInstance().ctx);
				//String iniInvarant= tIniInvarants.getText();
				//String evoInvarant = tEvoInvarants.getText();
				boolean r=validator.checkPrecondition(Data.getInstance().ctx, iniPrecondition, evoPrecondition);
				MessageBox resultBox= new MessageBox(shlConsistencyValidating,SWT.OK|SWT.CENTER);
				resultBox.setText("Result");
				if(r== true)
					resultBox.setMessage("Precondition is Satisfy");
				else resultBox.setMessage("Precondition is not Satisfy");
				resultBox.open();
				}
			}
		});
		GridData gd_btnCheckPreconditions = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_btnCheckPreconditions.heightHint = 61;
		gd_btnCheckPreconditions.widthHint = 97;
		btnCheckPreconditions.setLayoutData(gd_btnCheckPreconditions);
		formToolkit.adapt(btnCheckPreconditions, true, true);
		btnCheckPreconditions.setText("Check Preconditions");
		new Label(shlConsistencyValidating, SWT.NONE);
		
				btnInitialPreconditionVariables = new Button(shlConsistencyValidating, SWT.BORDER | SWT.FLAT);
				btnInitialPreconditionVariables.addSelectionListener(new SelectionAdapter()
				{
					@Override
					public void widgetSelected(SelectionEvent e)
					{
						String text = tIniPreconditions.getText();
						String[] Variables = null;
						try
						{
							if (text == null || text == "")
							{
								MessageBox warn = new MessageBox(shlConsistencyValidating);
								warn.setMessage("Some variables were not set");
								warn.setText("Un-set Variable error");
								warn.open();
							}
							else
							{
								Variables = Data.getInstance().iniPre.analyzeText(Data.getInstance().ctx,text);
								Display d = Display.getDefault();
								VariableWindows variablesList = new VariableWindows(d);
								variablesList.setText("Initial Precondition");
								variablesList.setItem(Variables);
								variablesList.open();
							}
						}
						catch (Z3Exception e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				});
				GridData gd_btnInitialPreconditionVariables = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
				gd_btnInitialPreconditionVariables.widthHint = 165;
				btnInitialPreconditionVariables.setLayoutData(gd_btnInitialPreconditionVariables);
				formToolkit.adapt(btnInitialPreconditionVariables, true, true);
				btnInitialPreconditionVariables.setText("Initial Precondition Variables");
		new Label(shlConsistencyValidating, SWT.NONE);
		
				btnEvolutionPreconditionVariable = new Button(shlConsistencyValidating, SWT.BORDER | SWT.FLAT);
				btnEvolutionPreconditionVariable.addSelectionListener(new SelectionAdapter()
				{
					@Override
					public void widgetSelected(SelectionEvent e)
					{
						String text = tEvoPreconditions.getText();
						String[] Variables = null;
						try
						{
							if (text == null || text == "")
							{
								MessageBox warn = new MessageBox(shlConsistencyValidating);
								warn.setMessage("Some variables were not set");
								warn.setText("Un-set Variable error");
								warn.open();
							}
							else
							{
								Variables = Data.getInstance().evoPre.analyzeText(Data.getInstance().ctx,text);
								Display d = Display.getDefault();
								VariableWindows variablesList = new VariableWindows(d);
								variablesList.setText("Evolution Precondition");
								variablesList.setItem(Variables);
								variablesList.open();
							}
						}
						catch (Z3Exception e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnEvolutionPreconditionVariable.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
				formToolkit.adapt(btnEvolutionPreconditionVariable, true, true);
				btnEvolutionPreconditionVariable.setText("Evolution Precondition Variable");
		new Label(shlConsistencyValidating, SWT.NONE);
		
				lblNewLabel_2 = new Label(shlConsistencyValidating, SWT.WRAP);
				lblNewLabel_2.setAlignment(SWT.CENTER);
				GridData gd_lblNewLabel_2 = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
				gd_lblNewLabel_2.widthHint = 79;
				lblNewLabel_2.setLayoutData(gd_lblNewLabel_2);
				lblNewLabel_2.setText("Initial Postconditions");
				
						tIniPostconditions = new Text(shlConsistencyValidating,
								SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
						GridData gd_tIniPostconditions = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
						gd_tIniPostconditions.heightHint = 82;
						gd_tIniPostconditions.widthHint = 215;
						tIniPostconditions.setLayoutData(gd_tIniPostconditions);
						formToolkit.adapt(tIniPostconditions, true, true);
				
						lblNewLabel_3 = new Label(shlConsistencyValidating, SWT.WRAP);
						lblNewLabel_3.setAlignment(SWT.CENTER);
						GridData gd_lblNewLabel_3 = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
						gd_lblNewLabel_3.widthHint = 84;
						lblNewLabel_3.setLayoutData(gd_lblNewLabel_3);
						lblNewLabel_3.setText("Evolution Postconditions");
				
						tEvoPostconditions = new Text(shlConsistencyValidating,
								SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
						GridData gd_tEvoPostconditions = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
						gd_tEvoPostconditions.widthHint = 191;
						gd_tEvoPostconditions.heightHint = 124;
						tEvoPostconditions.setLayoutData(gd_tEvoPostconditions);
						formToolkit.adapt(tEvoPostconditions, true, true);
		
		btnCheckPostconditions = new Button(shlConsistencyValidating, SWT.BORDER | SWT.CENTER|SWT.WRAP);
		btnCheckPostconditions.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(Data.getInstance().iniPost.variables==null
						||Data.getInstance().evoPost.variables==null)
				{
					MessageBox r = new MessageBox(shlConsistencyValidating, SWT.CENTER|SWT.OK|SWT.ICON_ERROR);
					r.setText("Missing variables");
					r.setMessage("Some of variable was not set");
					r.open();
				}
				else
				{
				//Expr iniPrecondition = Data.getInstance().iniPre.generateExpr(Data.getInstance().ctx);
				Expr iniPostcondition =Data.getInstance().iniPost.generateExpr(Data.getInstance().ctx);
				//Expr evoPrecondition = Data.getInstance().evoPre.generateExpr(Data.getInstance().ctx);
				Expr evoPostcondition =Data.getInstance().evoPost.generateExpr(Data.getInstance().ctx);
				//String iniInvarant= tIniInvarants.getText();
				//String evoInvarant = tEvoInvarants.getText();
				int r=validator.checkPostCondition(Data.getInstance().ctx, iniPostcondition, evoPostcondition);
				MessageBox resultBox= new MessageBox(shlConsistencyValidating,SWT.OK|SWT.CENTER);
				resultBox.setText("Result");
				if(r== 0)
					resultBox.setMessage("Postcondition is Equivalent");
				else if(r==1) resultBox.setMessage("Initial implies Evolution");
				else resultBox.setMessage("Postcondition not equivalent");
				resultBox.open();
				}
			}
		});
		GridData gd_btnCheckPostconditions = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_btnCheckPostconditions.heightHint = 65;
		gd_btnCheckPostconditions.widthHint = 83;
		btnCheckPostconditions.setLayoutData(gd_btnCheckPostconditions);
		formToolkit.adapt(btnCheckPostconditions, true, true);
		btnCheckPostconditions.setText("Check Postconditions");
		new Label(shlConsistencyValidating, SWT.NONE);
		
				btnInitialPostconditionVariables = new Button(shlConsistencyValidating, SWT.BORDER | SWT.FLAT);
				btnInitialPostconditionVariables.addSelectionListener(new SelectionAdapter()
				{
					@Override
					public void widgetSelected(SelectionEvent e)
					{
						String text = tIniPostconditions.getText();
						String[] Variables = null;
						try
						{
							if (text == null || text == "")
							{
								MessageBox warn = new MessageBox(shlConsistencyValidating);
								warn.setMessage("Some variables were not set");
								warn.setText("Un-set Variable error");
								warn.open();
							}
							else
							{
								Variables = Data.getInstance().iniPost.analyzeText(Data.getInstance().ctx,text);
								Display d = Display.getDefault();
								VariableWindows variablesList = new VariableWindows(d);
								variablesList.setText("Initial Postcondition");
								variablesList.setItem(Variables);
								variablesList.open();
							}
						}
						catch (Z3Exception e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				});
				btnInitialPostconditionVariables.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
				formToolkit.adapt(btnInitialPostconditionVariables, true, true);
				btnInitialPostconditionVariables.setText("Initial Postcondition Variables");
		Menu menu = new Menu(shlConsistencyValidating, SWT.BAR);
		shlConsistencyValidating.setMenuBar(menu);
		
		MenuItem mFile = new MenuItem(menu, SWT.CASCADE);
		mFile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				 FileDialog fd = new FileDialog(shlConsistencyValidating, SWT.OPEN);
			        fd.setText("Open");
			        fd.setFilterPath("C:/");
			        String[] filterExt = { "*.me*" };
			        fd.setFilterExtensions(filterExt);
			        String selected = fd.open();
			        readfile(selected);
			}
		});
		mFile.setText("File");
		
				MenuItem miAbout = new MenuItem(menu, SWT.NONE);
				miAbout.setText("About");
		new Label(shlConsistencyValidating, SWT.NONE);
		
				btnEvolutionPostconditionVariables = new Button(shlConsistencyValidating, SWT.BORDER | SWT.FLAT);
				btnEvolutionPostconditionVariables.addSelectionListener(new SelectionAdapter()
				{
					@Override
					public void widgetSelected(SelectionEvent e)
					{
						String text = tEvoPostconditions.getText();				
						String[] Variables;
						try
						{
							if (text == null || text == "")
							{
								MessageBox warn = new MessageBox(shlConsistencyValidating);
								warn.setMessage("Some variables were not set");
								warn.setText("Un-set Variable error");
								warn.open();
							}
							else
							{
								Variables = Data.getInstance().evoPost.analyzeText(Data.getInstance().ctx,text);
								Display d = Display.getDefault();
								VariableWindows variablesList = new VariableWindows(d);
								variablesList.setText("Evolution Postcondition");
								variablesList.setItem(Variables);
								variablesList.open();
							}
						}
						catch (Z3Exception e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnEvolutionPostconditionVariables.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
				formToolkit.adapt(btnEvolutionPostconditionVariables, true, true);
				btnEvolutionPostconditionVariables.setText("Evolution Postcondition Variables");
		new Label(shlConsistencyValidating, SWT.NONE);
		new Label(shlConsistencyValidating, SWT.NONE);
		new Label(shlConsistencyValidating, SWT.NONE);
		new Label(shlConsistencyValidating, SWT.NONE);
						new Label(shlConsistencyValidating, SWT.NONE);
						new Label(shlConsistencyValidating, SWT.NONE);
						new Label(shlConsistencyValidating, SWT.NONE);
						new Label(shlConsistencyValidating, SWT.NONE);
						new Label(shlConsistencyValidating, SWT.NONE);
						
								btnResult = new Button(shlConsistencyValidating, SWT.NONE);
								GridData gd_btnResult = new GridData(SWT.RIGHT, SWT.BOTTOM, false, false, 1, 1);
								gd_btnResult.widthHint = 94;
								btnResult.setLayoutData(gd_btnResult);
								btnResult.setText("Result");
								btnResult.addSelectionListener(new SelectionAdapter()
								{
									public void widgetSelected(SelectionEvent e)
									{
//				IntExpr a= ctx.mkIntConst("a");
//				IntExpr b= ctx.mkIntConst("b");
//				Solver s= ctx.mkSolver();
//				s.add(ctx.mkEq(a, b));
//				Status st= s.check();
//				if(st == Status.SATISFIABLE) 
//				{
//					MessageBox r = new MessageBox(shlConsistencyValidating,SWT.OK);
//					r.setMessage("valid");
//					r.open();
//				}
										
										if(Data.getInstance().iniPre.variables==null
												||Data.getInstance().iniPost.variables==null
												||Data.getInstance().evoPre.variables==null
												||Data.getInstance().evoPost.variables==null
												||tIniInvarants.getText()==null|| tIniInvarants.getText().length()==0
												||tEvoInvarants.getText()==null||tEvoInvarants.getText().length()==0)
										{
											MessageBox r = new MessageBox(shlConsistencyValidating, SWT.CENTER|SWT.OK|SWT.ICON_ERROR);
											r.setText("Missing variables");
											r.setMessage("Some of variable was not set");
											r.open();
										}
										else
										{
										Expr iniPrecondition = Data.getInstance().iniPre.generateExpr(Data.getInstance().ctx);
										Expr iniPostcondition =Data.getInstance().iniPost.generateExpr(Data.getInstance().ctx);
										Expr evoPrecondition = Data.getInstance().evoPre.generateExpr(Data.getInstance().ctx);
										Expr evoPostcondition =Data.getInstance().evoPost.generateExpr(Data.getInstance().ctx);
										String iniInvarant= tIniInvarants.getText();
										String evoInvarant = tEvoInvarants.getText();
										Result r=validator.validateConditions(Data.getInstance().ctx, iniInvarant, evoInvarant, iniPrecondition, iniPostcondition, evoPrecondition, evoPostcondition);
										MessageBox resultBox= new MessageBox(shlConsistencyValidating,SWT.OK|SWT.CENTER);
										resultBox.setText("Result");
										switch (r)
										{
										case TOTAL_CONSISTENCY:
											resultBox.setText("Total Consistency");
											break;
										case PARTIAL_CONSISTENCY:
											resultBox.setText("Partial Consistency");
											break;
										case UNCONSISTENCY:
											resultBox.setText("Unconsistency");
											break;
										default:
											break;
										}
										}
									}
								});
						
								btnExit = new Button(shlConsistencyValidating, SWT.PUSH);
								GridData gd_btnExit = new GridData(SWT.CENTER, SWT.FILL, false, false, 1, 1);
								gd_btnExit.widthHint = 94;
								btnExit.setLayoutData(gd_btnExit);
								btnExit.setText("Exit ");
								btnExit.addSelectionListener(new SelectionAdapter()
								{
									public void widgetSelected(SelectionEvent e)
									{
										System.exit(0);
									}
								});
	}
	public void readfile(String fileName)
	{
		try
		{
			BufferedReader br = new BufferedReader( new FileReader(fileName));
			String currentLine= null;
			try
			{
				String[] listTmp = {"@initial_invarant: ","@initial_precondition: ","@initial_postcondition: "
						,"@evolution_invarant: ","@evolution_precondition: ","@evolution_postcondition:"};
				while((currentLine= br.readLine())!= null)
				{
					for(int i=0;i<listTmp.length;i++)
					{
						if(currentLine.contains(listTmp[i]))
						{
							String tmp = currentLine.substring(listTmp[i].length());
							switch(i)
							{
							case 0:
								tIniInvarants.setText(tmp);
								break;
							case 1:
								tIniPreconditions.setText(tmp);
								break;
							case 2:
								tIniPostconditions.setText(tmp);
								break;
							case 3:
								tEvoInvarants.setText(tmp);
								break;
							case 4:
								tEvoPreconditions.setText(tmp);
								break;
							case 5:
								tEvoPostconditions.setText(tmp);
								break;
								default: break;
							}
						}
					}
				}
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
