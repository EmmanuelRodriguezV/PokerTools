package sample.Rules;

import sample.Interfaces.IRule;
import sample.Models.Connect;
import sample.Enums.OPENRAISE_POSITIONS;
public class OpenRaise  implements IRule {


    @Override
    public String resolver(String carta,int posicion) {
        Connect connect = new Connect();
        int posicioncarta = connect.getOpenRaiseValue(carta);
        OPENRAISE_POSITIONS newposition = OPENRAISE_POSITIONS.values()[posicion-1];
        String desicion = "";
        if (posicioncarta == 0)
        {
            desicion = "fold";
            return  desicion;
        }
        switch (newposition)
        {
            case UNDER_THE_GUN:
                if(posicioncarta <= posicion)
                    desicion = "sube 3 bbs";
                else
                    desicion = "fold";
                break;
            case MIDDLE_POSITION:
                if(posicioncarta <= posicion)
                    desicion = "sube 3 bbs";
                else
                    desicion = "fold";
                break;
            case CUT_OFF:
                if(posicioncarta <= posicion)
                    desicion = "sube 3 bbs";
                else
                    desicion = "fold";
                break;
            case BUTTON:
                if(posicioncarta <= posicion)
                    desicion = "sube 2.5 bbs";
                else
                    desicion = "fold";
                break;
            case SMALL_BLIND:
                if(posicioncarta <= posicion)
                    desicion = "sube 3 bbs";
                else
                    desicion = "fold";
                break;
        }
        return  desicion;
    }


}
