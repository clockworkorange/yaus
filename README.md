yaus
====

YAUS: Yet Another URL Shortener

Permite la creación de URLs recortadas y la redirección a la URL original:

    - Utilización de base62 para la conversión:

        caracteres comprendidos a..z, A..Z, 0..9

    - Tamaño de 5 dígitos del código autogenerado (configurable)


Destacados:

    - Test unitarios y de integración.

    - Codenarc

    - Utilización database migration plugin para la creación y actualización de la BBDD MySQL


TODO:

    - Infraestructuras: Desplieges de máquinas y BBDDs en AWS mediante cloudformation de entornos de preproducción y
      producción

    - Aplicaciones de monitorización (JavaMelody, Nagios, Cacti...)

    - Posibilidad de visualización/gestión de URLs generadas (perfil administrador)

    - Capacidad de generación de reportes mediante aplicaciones que obtengan información de la BBDD (OpenReport/JasperReport)