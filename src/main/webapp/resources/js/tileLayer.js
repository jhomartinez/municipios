//This demo shows how to create a map that displays a 'Hello World!' marker
//on a world map tile layer. It also shows how to add various map controls
//such as the navigation bar, the scale bar and a copyright note.

//Tile layers are background maps typically hosted by well known map service
//providers such as Google, Bing and HERE et al. Oracle also
//provides its own map services for use by various Oracle products and their customers.
//This is the map tile layer we will be showing in this demo.

//_showMap_ is a wrapper function that includes all the mapping related logic
//for this demo. It is invoked in the document-ready function from the corresponding
//html page.
function showMap() {

    OM.gv.setResourcePath("../..");
    OM.gv.setHttpMethod('GET');
    
    //This is the DIV that will display the map; it needs to be passed into
    //the map instance.
    var mapDiv = document.getElementById('map');

    var config = 
        {
            srid: 21897,
            bounds: new OM.geometry.Rectangle(-75.5800, -2.5000, -72.5800, 11.9000, 21897),
            numberOfZoomLevels: 10
        };
    var mapJhon = new OM.universe.Universe(config); 
    //Creates a new map instance. Notice we are not supplying a Universe
    //like in helloworld.js, since the universe will be defined when we
    //add the tile layer to the map. Every tile layer includes its own
    //universe definition as part of the tile layer's configuration.
    
    var mapOptions = {
        mapviewerURL: '',
        universe: mapJhon
    };

    var map = new OM.Map(mapDiv, mapOptions);

    //This is how we create an Oracle eLocation tile layer: by creating
    //a new instance of the OM.layer.ElocationTileLayer class. Check
    //the <a href="../../../apidoc/index.html">API Doc</a> for other built-in tile 
    //layers such as <a href="../../../apidoc/symbols/OM.layer.BingTileLayer.html">Bing maps</a>.
    var tileLayer = new OM.layer.ElocationTileLayer();

    //Adds the tile layer to the map.  That's it!
    map.addLayer(tileLayer);

    //creates a point object located at the longitude 0 and latitude 1. 
    var point = new OM.geometry.Point(-74.074515,4.643209); 

    //now creates a feature object for the point. You must specify a 
    //unique ID (within a layer), 'pt_1' in this case. We are also 
    //specifying a label text 'Hello World!' for this feature.
    var feature = new OM.Feature('pt_1', point, {label: "Aqui Jhon"});

    var mapCenterLon = 9.73851072942375;
    var mapCenterLat = -74.8985031852844;
    var mapZoom = 8;
    var mpoint = new OM.geometry.Point(mapCenterLon,mapCenterLat,8307);
    map.setMapCenter(mpoint);
    map.setMapZoomLevel(mapZoom);
    //creates the vector layer for the marker
    var layer = new OM.layer.VectorLayer('Layer 1',  {
      def: { type: OM.layer.VectorLayer.TYPE_LOCAL }
    });

    //adds the point feature to the layer
    layer.addFeature(feature);

    //ensure the feature's label text is displayed on the map
    layer.setLabelsVisible(true);

    //finally, adds the layer to the map for display
    map.addLayer(layer);

    //Adds various map controls to the map.
    addMapControls(map);

     // set the initial zoom level
     map.setMapZoomLevel(5);
    //Now we can complete the initialization of the map. You must
    //only call this method once.  Note however map layers can
    //be added even after calling this method.
    map.init();
};

//This function adds various map controls to the provided OM.Map instance.
function addMapControls(myMap)
{
    //defines various properties for the navigation control
    var navConfig = {
        orientation: 1,
        style: OM.control.NavigationPanelBar.STYLE_FULL,
        anchorPosition: 1
    };

    //creates the navigation control
    var navigationControl = new OM.control.NavigationPanelBar(navConfig);

    // navigation control (and other map controls) are typically added
    //to the map as map decorations.
    myMap.addMapDecoration(navigationControl);

    //defines the basic properties for the map scale bars
    var sbConfig = {
        format: "BOTH",   
        anchorPosition: 4, 
        endMarks: false
    };

    //defines the display style of the scale bars
    var sbStyle = {
        thickness:5, 
        color: '#257db3', 
        shadow:true
    };

    //creates the actual sacle bar instance and sets the display style
    var scaleBar = new OM.control.ScaleBar(sbConfig);
    scaleBar.setStyle(sbStyle);

    //adds the scale bar to the map as another map decoration
    myMap.addMapDecoration(scaleBar);   

    //creates a new map decoration for the copyright text
    var copyrigtControl = new OM.control.CopyRight({        
        anchorPosition:5,
        textValue:"©2014 Oracle and/or its affiliates. Map data ©2013 HERE",
        fontSize:11,
        fontFamily:'"Gill Sans","Helvetics Neue",Helvetica,Arial,sans-serif',//"Arial"
        fontColor:"#104a7e"//"black"        
    });

    myMap.addMapDecoration(copyrigtControl);

}