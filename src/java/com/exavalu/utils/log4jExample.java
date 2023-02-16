/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.utils;

/**
 *
 * @author Anik Dutta
 */
import org.apache.log4j.Logger;

import java.io.*;
import java.sql.SQLException;

public class log4jExample{
   /* Get actual class name to be printed on */
   static Logger log = Logger.getLogger(log4jExample.class.getName());
   
   public static void main(String[] args)throws IOException,SQLException{
      log.debug("Hello this is an debug message");
      log.info("Hello this is an info message");
      log.error("Hello this is an error message");
}
}
