package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    // for { : n&n
    @Test
    public void testIsBalancedCase1(){
        String val = "{{bonjour}}"; 

        boolean res = isBalanced(val);
        
        assertEquals(true, res);
    }

    // for { : n&m
    @Test
    public void testIsBalancedCase2(){
        String val = "{{bonjour}}}"; 

        boolean res = isBalanced(val);
        
        assertEquals(false, res);
    }

    // for { : n&m
        @Test
        public void testIsBalancedCase2_(){
            String val = "{{{bonjour}}"; 
    
            boolean res = isBalanced(val);
            
            assertEquals(false, res);
        }

    // for [ : n&n
    @Test
    public void testIsBalancedCase3(){
        String val = "[[bonjour]]"; 

        boolean res = isBalanced(val);
        
        assertEquals(true, res);
    }

    // for [ : n&m
    @Test
    public void testIsBalancedCase4(){
        String val = "[[bonjour]]]"; 

        boolean res = isBalanced(val);
        
        assertEquals(false, res);
    }

    // for [ : n&m
    @Test
    public void testIsBalancedCase4_(){
        String val = "[[[bonjour]]"; 

        boolean res = isBalanced(val);
        
        assertEquals(false, res);
    }

    // for ( : n&n
    @Test
    public void testIsBalancedCase5(){
        String val = "((bonjour))"; 

        boolean res = isBalanced(val);
        
        assertEquals(true, res);
    }

    // for ( : n&m
    @Test
    public void testIsBalancedCase6(){
        String val = "((bonjour)))"; 

        boolean res = isBalanced(val);
        
        assertEquals(false, res);
    }

    // for ( : m&n
    @Test
    public void testIsBalancedCase6_(){
        String val = "(((bonjour))"; 

        boolean res = isBalanced(val);
        
        assertEquals(false, res);
    }

}