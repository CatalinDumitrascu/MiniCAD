# MiniCAD

This program receives input in a .txt file as following:

23                                                                                                                                     
CANVAS 602 713 #B45DE4 100                                                                                                               
CIRCLE 276 255 246 #C3B0B2 100 #5CB282 100                                                                                  
CIRCLE 134 17 68 #CDF4A0 100 #F6534D 100                                                                            
LINE 618 357 626 586 #B3F07D 100                                                        
CIRCLE 542 369 273 #EDDAAC 100 #B8EF37 100                                                  
SQUARE 136 60 868 #DD22CD 100 #3B9077 100                                                   
TRIANGLE 633 50 462 487 124 347 #8F97E0 100 #45A20C 100                                                     
LINE 560 194 60 210 #25CBA2 100                                                                 
TRIANGLE 120 362 453 390 137 449 #F09C1D 100 #F1646F 100                                                            
LINE 532 542 695 385 #0A62DA 100                                                            
CIRCLE 667 160 265 #C61E31 100 #D7CD15 100                                                      
CIRCLE 349 140 283 #E6C500 100 #E08C7B 100                                                          
DIAMOND 99 365 300 501 #FD40C2 100 #326557 100                                                          
TRIANGLE 51 31 267 84 339 43 #2416EC 100 #33CB69 100                                                        
DIAMOND 255 16 512 996 #AC26EC 100 #941086 100                                                                  
LINE 224 265 347 554 #808F48 100                                                                        
RECTANGLE 603 478 841 825 #B8FAF7 100 #276363 100                                                                           
DIAMOND 15 515 964 151 #D1CCED 100 #6FE4DE 100                                                                          
RECTANGLE 535 54 442 526 #86BBF1 100 #0613CD 100                                                                                
POLYGON 6 421 10 411 120 519 249 560 199 569 90 460 23 #1E95E5 100 #2A5235 100                                                  
DIAMOND 686 569 437 567 #58FE25 100 #40149A 100                                                                 
LINE 682 550 345 379 #897D67 100                                                                            
SQUARE 153 337 762 #89BF39 100 #F6F36B 100                                                                      
 
POLYGON 5 15 400 120 490 160 560 120 700 100 520 #150C73 100 #FAD613 100                                                            

  23 is the number of figures that are to be drawn.
  CANVAS is always the first one, and it is described by heigth, width, colour and alpha value.
  A CIRCLE is described by the coordinates of its centre, the length of its radius, colour of its outline, alpha value of this colour, colour of its inside, and its respective alpha.
  A LINE has 2 coordinates, a SQUARE has the coords of its top-left corner and the length of the side, a TRIANGLE has the coordinates of its 3 vertexes, and a polygon has the coords all of its vertexes.
  The program "draws" the figures consecutively, with the latter ones being the ones on top if some of them intersect.
