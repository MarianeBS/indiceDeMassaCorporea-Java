package padrao;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.text.DecimalFormat;
/**
 *
 * @author Mariane
 */
public class IMC extends JFrame
{
    JLabel titulo, label1, label2, exibir;
    JTextField massa, altura;
    JButton calcular, limpar;
    
    public DecimalFormat df = new DecimalFormat ("0.00");
   
    public IMC()
    {
        super("IMC");
        Container tela = getContentPane();
        setLayout(null);
        titulo = new JLabel ("Índice de Massa Corpórea");        
        label1 = new JLabel ("Altura (m):");
        label2 = new JLabel ("Massa (kg):");       
        massa = new JTextField (5);
        altura = new JTextField (5);       
        calcular = new JButton ("Calcular");
        limpar = new JButton ("Limpar");
        exibir = new JLabel ("");
        
        titulo.setBounds (65, 30, 300, 25);
        
        label1.setBounds (85, 90, 150, 20);
        altura.setBounds (175, 90, 100, 20);
        
        label2.setBounds (85, 130, 150, 20);
        massa.setBounds (175, 130, 100, 20);        
        
        calcular.setBounds (70, 180, 120, 25);
        limpar.setBounds (190, 180, 120, 25);
        
        exibir.setBounds (150, 225, 300, 20);
        
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        label1.setFont(new Font("Arial", Font.BOLD, 16));
        label2.setFont(new Font("Arial", Font.BOLD, 16));        
        calcular.setFont(new Font("Arial", Font.BOLD, 16));
        limpar.setFont(new Font("Arial", Font.BOLD, 16));
        exibir.setFont(new Font("Arial", Font.BOLD, 16));
        
        calcular.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    double a, m, imc;
                    imc = 0.00;
                    a = Double.parseDouble(altura.getText());
                    m = Double.parseDouble(massa.getText());
                    imc = m / (a*a);
                   
                    if (imc >= 25)
                    {  
                        exibir.setVisible(true);    
                        exibir.setText("Acima do Peso");
                    }
                    
                    else if (imc >= 18.5)
                    {
                        exibir.setVisible(true);    
                        exibir.setText("Peso Ideal");
                    
                    }
                  
                    else
                    {
                        exibir.setVisible(true);    
                        exibir.setText("Abaixo do Peso");                   
                    }
                } 
            }
        );
        
        limpar.addActionListener
        (
            new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    altura.setText(null);
                    massa.setText(null);                  
                    exibir.setText(null);
                    altura.requestFocus();  
                } 
            }
        );
        
        exibir.setVisible(false);
        
        tela.add(titulo);
        
        tela.add(label1);
        tela.add(altura);
        
        tela.add(label2);
        tela.add(massa);
        
        tela.add(calcular);
        tela.add(limpar);
        
        tela.add(exibir);
        
        tela.setBackground(new Color(8, 247, 125));
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(400, 300);
        setVisible(true);            
    } 
}
