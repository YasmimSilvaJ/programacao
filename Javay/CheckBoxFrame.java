package javaapplication5;

//Criando botões JCheckBox.
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class CheckBoxFrame extends JFrame{
    private JTextField textField;
    private JCheckBox boldJCheckBox;
    private JCheckBox italicJCheckBox;
    
    //construtor CheckBoxFrame adiciona JCheckBoxes ao JFrame
    public CheckBoxFrame(){
        super( "JCheckBox Test" );
        setLayout( new FlowLayout() );// configura o layout de frame
        
        //configura JTexField e sua font
        textField = new JTextField( "watch the font style change", 20 );
        textField.setFont( new Font( "Serif" , Font.PLAIN, 14 ));
        add( textField ); //adiciona textField ao JFrame
        
        boldJCheckBox = new JCheckBox( "Bold" ); //cria caixa de seleção´para negrtito
        italicJCheckBox = new JCheckBox( "Italic" ); //cria itálico
        add( boldJCheckBox ); //adiciona caixa de seleção de estilo negrito ao JFrame
        add( italicJCheckBox ); //adiciona caixa de seleção de itálico ao JFrame
        
        //listeners registradores para JChckBoxes
        CheckBoxHandler handler = new CheckBoxHandler();
        boldJCheckBox.addItemListener( handler );
        italicJCheckBox.addItemListener( handler );
    }//fim do construtort CheckBoxFrame
    
    //classse interna private para tratamento de evento ItemListener
    private class CheckBoxHandler implements ItemListener
    {
        //responde aos eventos da caixa de seleção
        public void itemStateChanged( ItemEvent event )
        {
            Font font = null; //armazena a nova Font
            
            //determina que CheckBoxes estão marcadas e cria Font
            if (boldJCheckBox.isSelected()&& italicJCheckBox.isSelected() )
                font = new Font( "Serif" , Font.BOLD + Font.ITALIC, 14 );
            else if (boldJCheckBox.isSelected() )
                font = new Font( "Serif", Font.BOLD, 14);
            else if (italicJCheckBox.isSelected() )
                font = new Font( "Serif", Font.ITALIC, 14 );
            else 
                font = new Font( "Serif", Font.PLAIN, 14 );
            
            textField.setFont( font );//configura a fonte do textField
        }
    }    
}
