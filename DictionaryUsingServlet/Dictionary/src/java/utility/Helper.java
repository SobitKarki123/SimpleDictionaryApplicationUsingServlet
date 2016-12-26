/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.List;
import model.Entries;


public class Helper {
    
    public static String resultFormatting(List<Entries> lst){
        if(lst.isEmpty()){
        return "<div class='nodata alert alert-danger'>Oops.. No result found!!</div>";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<div class='definitionSet'>");
        sb.append("<ol>");
        
        for(Entries e : lst){
            if(e.wordtype.isEmpty())
            sb.append("<li> ").append(e.definition).append(" </li>");
                 else
            sb.append("<li> <strong>(").append(e.wordtype).append(")</strong> :: ").append(e.definition).append(" </li>");
       
        }
        
           sb.append("</ol>");
           sb.append("</div>");
    return sb.toString();
    }
}
