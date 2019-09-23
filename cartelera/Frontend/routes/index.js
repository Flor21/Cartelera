var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

/* POST signUp. */
router.post('/signUp', function signUp (req, res) {
  console.log('Registrando usuario: ', req.body)
});

module.exports = router;
