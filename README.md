# Datapoa Java Client Library

The DataPoa Client Library for Java is a flexible, efficient, and powerful Open Source Java client library for accessing Porto Alegre's open data. 

## Accessing API from Porto Alegre Open Data

To access data from DataPoa API with this library you will need use DataPoaClient as below:

```

        DataPoaResource dpResource = new DataPoaResourceQueryBuilder().resource(resourceId).build();
    	 
        DataPoaEntity data = new DataPoaClient(dpResource).doRequest();
        
        for (JsonObject jsonObject : data.getResult().getRecords()) {
	        System.out.println(jsonObject.get("<COLUMN_NAME>"));
        }
    	
```
More details can be found on Unit Tests.

## Creating Url Customized Results

To customize results this library is Flexible you can extend DataPoaEntity.class and implement your customized result. To use DataPoaClient use:

```

    CustomizedResultEntity result = new DataPoaClient(dpResource).doRequest(CustomizedResultEntity.class);

```
More details can be found on Unit Tests.

#Build and Run

The easiest way to build this library is with Gradle but you can pick your own way to do it. 

```

     $ git clone https://github.com/DataPoa/datapoa-java-client.git
     $ cd datapoa-java-client
     $ gradle build

```

## Contributing
 
- As User

1. Create New Features Issues
2. Create Bug Issues

- As Developer
 
1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request

** IMPORTANT: Pull requests must have Unit Tests.
 
## License
This project is under MIT License.

### Authors / Contributors
Cristian Oliveira - (https://github.com/CristianOliveiraDaRosa)