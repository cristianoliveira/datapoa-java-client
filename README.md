
# Datapoa Java Client Library
[![Build Status](https://travis-ci.org/CristianOliveiraDaRosa/datapoa-java-client.svg?branch=master)](https://travis-ci.org/CristianOliveiraDaRosa/datapoa-java-client)

The DataPoa Client Library for Java is a flexible, efficient, and powerful Open Source Java client library for accessing Porto Alegre's open data.

## About #DataPoa

The #DataPoa is a portal with open data from Porto Alegre, Brazil. It has the main goal to bring the community to use this data to create smart solutions for the city.

### About Data

This API has a lot of different kind of data like Mobility, Heath, Education and others.

DataPoa Portal http://datapoa.com.br/

DataPoa API http://datapoa.com.br/dataset

## Instalation

Add this library as dependency with Gradle or Maven:

### Gradle
```
  compile 'br.com.datapoa:datapoa-java-client:1.+'
```

### Maven
```xml
<dependency>
    <groupId>br.com.datapoa</groupId>
    <artifactId>datapoa-java-client</artifactId>
    <version>1.0.2</version>
</dependency>
```

## Accessing API from Porto Alegre Open Data

To access data from DataPoa API with this library you will need use DataClient as below:

```

    DataResourceBuilder builder = new DataResourceBuilder().resource(resourceId);
    DataResource dpResource = builder.build();
    
    DataEntity data = new DataClient(dpResource).doRequest();

    for (JsonObject record : data.getResult().getRecords()) {
        System.out.println(record.get(0));
    }

```
Examples can be found on Unit Tests

## Creating Customized Results

We made this library to be flexible. Then you can extend DataEntity.class and implement your customized result. Using DataClient:

```

    CustomizedResultEntity result = new DataClient(dpResource).doRequest(CustomizedResultEntity.class);

```
More details can be found on Unit Tests.

## Executing Asynchronous Requests

To execute a request asynchronous you must to create a callback class implementing IDataRequestAsyncCallback<MyEntity> interface and sending it to DataClient:

```
    
    MyCallback callback = new MyCallback();
    DataResourceBuilder builder = new DataResourceBuilder().resource(resourceId);
    DataResource dpResource = builder.build();
    
    new DataClient(dpResource).doAsyncRequest(DataEntity.class, callback);

```
More details can be found on Unit Tests.

## Getting Request Exceptions

When an error occur during the request it will raise a DataRequestException with the point where error occurred

```
     
      try {
    		data = new DataClient(dpResource).doRequest();
    		
		} catch (DataRequestException e) {
		   int point = e.getPointWhenErrorOccurred();
			
         switch (point) {
		     case DataRequestException.WHEN_REQUESTING_DATA:
		        ...
			  break;
			  case DataRequestException.WHEN_PARSING_DATA:
			     ...
			  break;
			  case DataRequestException.WHEN_POSTING_DATA:
			     ...
			  break;

			default:
				break;
			}
		}

```
More details can be found on Unit Tests.

### How can I get Resource ID?

Access DataPoa Portal and pick one data set. Enter in "Explorar"and "API Dados" in this page you'll be able to figure out the Resource Id. 

#Build and Run

The easiest way to build this library is with Gradle but you can pick your own way to do it.

```

     $ git clone https://github.com/DataPoa/datapoa-java-client.git
     $ cd datapoa-java-client
     $ gradle build

```

## Contributing

- **As User**

   1. Create New Features Issues
   2. Create Bug Issues

- **As Developer**

   1. Fork it!
   2. Create your feature branch: `git checkout -b my-new-feature`
   3. Commit your changes: `git commit -am 'Add some feature'`
   4. Push to the branch: `git push origin my-new-feature`
   5. Submit a pull request

**IMPORTANT**: Pull requests must have Unit Tests.

## License
This project is under MIT License.

### Authors / Contributors
Cristian Oliveira - (https://github.com/CristianOliveiraDaRosa)
