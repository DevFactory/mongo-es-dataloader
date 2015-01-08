curl -XGET "http://localhost:9200/3gear/institution/_search/template" -d '
{
	"template": 
	{
		"query": 
		{ 
			"match" : 
			{
				"area" : "{{varea}}"
			} 
		}
	},
	"params" : 
	{
		"varea" : "basaveshwara nagar"	
	}
}'
