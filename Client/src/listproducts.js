import { useState } from 'react';
import { useEffect } from 'react';
import { Card } from "react-bootstrap"
import "bootstrap/dist/css/bootstrap.min.css";



const [contentt, setContentt] = useState([]);

const [link, setlink] = useState();


const listproducts = (d) => {



    setlink(d)

    var url2 = 'http://localhost:8080/product/categories/' + link


    fetch(url2)
        .then(response => response.json())
        .then(data => {

            setContentt(data);
        }).catch(e => {
            console.warn("e : ", e);
        });


    {
        contentt.map(v => {

            <div className="ListProducts">
                return (

        <Card style={{ width: '18rem' }}>
                    <Card.Img variant="top" src="https://blog.n11.com/wp-content/uploads/2014/11/yemek-fotografi-kompozisyonu.jpg" />
                    <Card.Body>
                        <Card.Title>{v.name}</Card.Title>
                        <Card.Subtitle>{v.category}</Card.Subtitle>
                        <br />
                        <Card.Subtitle>{v.price}$</Card.Subtitle>

                        <Card.Text>
                            {v.description}
                        </Card.Text>

                    </Card.Body>
                </Card>

      )
      </div>


        })

    }



};

export default listproducts;
