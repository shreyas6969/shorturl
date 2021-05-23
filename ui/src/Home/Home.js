import React, { Component } from 'react'
import { Form, Input, Button, Select,Table } from 'antd';
import { Row, Col , Alert} from 'antd';
import './Home.css'
import axios from 'axios';



class Home extends Component {

     constructor(props){
         super(props);
         this.state={
             showTable:false,
             data:"",
             duplicateRow:false
         }
     }

   async componentDidMount(){
        await axios.get('http://localhost:8080/url/get/all', {
            responseType: 'json'
        }).then(response => {
            this.setState({
                data:response.data,
                showTable:true,
            })
        })
    }

    onFinish= (values)=>{
       this.setState({showTable:false});
        var formData={
            longUrl:"",
            shortUrl:"",

        }
        formData.longUrl=values.longUrl

        axios.post('http://localhost:8080/url/', formData
        ).then(response => {
            console.log(response.status)
          if(response.status= 200){
             axios.get('http://localhost:8080/url/get/all', {
                responseType: 'json'
            }).then(response => {
                this.setState({
                    data:response.data,
                    showTable:true,
                    duplicateRow:false
                })
            })
          }
          
        })
        .catch((error) => {
            axios.get('http://localhost:8080/url/get/all', {
                responseType: 'json'
            }).then(response => {
                this.setState({
                    showTable:true,
                    duplicateRow:true
                })
            })

        })

    }
    putUrl=(row)=>{
        axios.put('http://localhost:8080/url/'+row.urlId
        ).then(response => {
            if(response.status= 200){
                axios.get('http://localhost:8080/url/get/all', {
                   responseType: 'json'
               }).then(response => {
                   this.setState({
                       data:response.data,
                       showTable:true,
                   })
               })
             }
   
        })
    }
  render() {
    const columns = [
        { title: 'URL ID', dataIndex: 'urlId', key: 'urlId' },
        { title: 'Long URL', dataIndex: 'longUrl', key: 'longUrl' },
        { title: 'no_hits', dataIndex: 'no_hits', key: 'no_hits' },
        {
          title: 'Short Url',
          dataIndex: '',
          key: 'x',
          render: (text, row) => {
            return(
              <a 
                href={row.longUrl}
                target="_blank"
                onClick={()=>{this.putUrl(row)}}
                >
                    {row.shortUrl}
                </a>
              )
            
          }
        },
      ];

    return (
      <div className="main">
         <Form  name="control-ref" onFinish={this.onFinish}>
         <Row>
         <Col span={12}>
        <Form.Item name="longUrl" label="Enter Long Url" rules={[{ required: true, message:"Please Enter URL" }]}>
          <Input  placeholder="Please enter a url"/>
        </Form.Item>
        </Col>
        </Row>
        <Row>
        {this.state.duplicateRow &&
            <Alert message="The url is already present" type="error"/>  
        	  }
        </Row>
        <Row>
        <Col span={3} offset={10}>
        <Form.Item>
          <Button type="primary" htmlType="submit">
            Save
          </Button>
          </Form.Item>
          </Col>
          </Row>
          </Form>
          {this.state.showTable &&
          <Table
            columns={columns}
            dataSource={this.state.data}
          />
         }
      </div>
    )
  }
}
export default Home
