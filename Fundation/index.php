<!doctype html>
<html class="no-js" lang="en">
  <head>
  		<meta charset="utf-8" />
  		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>SAPCI | Página Principal</title> <!--Titulo de la pestaña-->


        <!-- .css y .ls necesarios para el funcionamiento de los elementos-->
        <link rel="stylesheet" href="css/default.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="css/foundation.css" />
        <script src="js/vendor/modernizr.js"></script>
        <script src="js/vendor/jquery.js"></script>
    	<script src="js/foundation.min.js"></script>

        <br></br>
        <br></br>
        <br></br>


    	<!-- script de .js necesarios para el funcionamiento del slider-->
        <script type="text/javascript" src="scripts/jquery-1.6.1.min.js"></script>
        <script type="text/javascript" src="scripts/jquery.nivo.slider.pack.js"></script>
        <script type="text/javascript">
        $(window).load(function() {
            $('#nslider').nivoSlider(); 
        });
        </script> <!--fin del script--> <!---->
        
        <!-- Stilo que tendra el panel que contiene las imagenes del slider-->
        <style>
            #slider { 
                margin:1 auto 7 auto;
                width:600px; 
                height:300px;

            	/*Sombra y bordes*/
                -webkit-box-shadow: 0px 1px 5px 0px #4a4a4a;
                -moz-box-shadow: 0px 1px 5px 0px #4a4a4a;
                box-shadow: 0px 1px 5px 0px #4a4a4a;
            }
        </style>

    </head> 

    <!-- Cuerpo de la página-->
	<body>

        <div class="row">
        <hr></hr>
            <div class="large-8 medium-8 columns">
		          <div id="slider"> <!-- Inicio del bloque slider-->
          	         <div id="nslider" class="nivoSlider"> 
				        <?php 
                        $directorio="img/sliderI"; /*Referencia a la carpeta img */
                        $dirint = dir($directorio); /* dir int contendrá la direccion de la carpeta /var/www/html/Fundation/img*/
						while (($archivo = $dirint->read()) !== false) /*leerá los archivos que se encuentren  en la carpeta*/
							{
							if (eregi("gif", $archivo) || eregi("jpg", $archivo) || eregi("png", $archivo) || eregi("jpeg", $archivo)){
								/*verifica que solo sean imagenes con extenciones gif,jpg,png,jpeg*/
								echo '<img src="'.$directorio."/".$archivo.'">'."\n" ;
								/* echo muestra la imagen leida*/
							}
						}
						$dirint->close(); /*Cierra la carpeta*/
				        ?>
			         </div>
		          </div>
            </div>
            <div class="large-4 medium-5 columns">
        		<div class="panel">
          			<a href="mantenimiento.php" class="small round button">Mantenimiento de datos</a>
                    <a href="http://foundation.zurb.com/docs/" class="small round button">Asignación de citas</a>
                    <a href="http://foundation.zurb.com/docs/" class="small round button">Consultas</a>         
        		</div>
      		</div>
        </div>


    	<script type="text/javascript"> 
    	$(document).foundation();
    	</script>



	</body>
</html>